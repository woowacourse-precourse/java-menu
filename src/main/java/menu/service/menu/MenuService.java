package menu.service.menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.coach.entity.Coach;
import menu.domain.coach.repository.CoachRepository;
import menu.domain.menu.Category;
import menu.domain.menu.entity.Menu;
import menu.domain.menu.repository.MenuRepository;
import menu.dto.menu.RecommendMenusDto;

public class MenuService {

    private static final int MIN_CATEGORY_NUMBER = 1;
    private static final int MAX_CATEGORY_NUMBER = 5;
    private static final int SELECT_MENU_INDEX = 0;
    private static final int LUNCH_COUNT = 5;
    private static final long MAX_DUPLICATE_LUNCH_CATEGORY = 2;

    private static final String NOT_FOUND_MENU_EXCEPTION_MESSAGE = "지정한 이름의 메뉴를 찾을 수 없습니다.";

    private final CoachRepository coachRepository;
    private final MenuRepository menuRepository;

    public MenuService(CoachRepository coachRepository, MenuRepository menuRepository) {
        this.coachRepository = coachRepository;
        this.menuRepository = menuRepository;
    }

    public RecommendMenusDto recommendLunchMenus() {
        List<Coach> coaches = coachRepository.findAll();
        List<Category> categories = new ArrayList<>();
        Map<Coach, List<Menu>> recommendMenus = calculateRecommendMenus(coaches, categories);

        return new RecommendMenusDto(categories, recommendMenus);
    }

    private Map<Coach, List<Menu>> calculateRecommendMenus(final List<Coach> coaches, final List<Category> categories) {
        Map<Coach, List<Menu>> recommendMenus = new HashMap<>();
        int count = 0;

        while (count++ < LUNCH_COUNT) {
            Category recommendCategory = findValidCategory(categories);
            List<String> menusName = menuRepository.findAllByCategory(recommendCategory).stream()
                    .map(Menu::getName).collect(Collectors.toList());
            processAddRecommendMenus(recommendMenus, menusName, coaches);
        }
        return recommendMenus;
    }

    private void processAddRecommendMenus(final Map<Coach, List<Menu>> recommendMenus,
        final List<String> menus, final List<Coach> coaches) {
        coaches.forEach(coach -> {
            List<Menu> previousRecommendMenus = recommendMenus.getOrDefault(coach, new ArrayList<>());
            Menu recommendEatableMenu = findUniqueRecommendEatableMenu(menus, coach, previousRecommendMenus);

            previousRecommendMenus.add(recommendEatableMenu);
            recommendMenus.put(coach, previousRecommendMenus);
        });
    }

    private Menu findUniqueRecommendEatableMenu(final List<String> menus, final Coach coach,
        final List<Menu> previousRecommendMenus) {
        Menu recommendEatableMenu = findRecommendEatableMenu(menus, coach);

        while (previousRecommendMenus.contains(recommendEatableMenu)) {
            recommendEatableMenu = findRecommendEatableMenu(menus, coach);
        }
        return recommendEatableMenu;
    }

    private Menu findRecommendEatableMenu(final List<String> menus, Coach coach) {
        String randomMenuName = Randoms.shuffle(menus).get(SELECT_MENU_INDEX);

        while (coach.matchesByInedibleMenuByName(randomMenuName)) {
            randomMenuName = Randoms.shuffle(menus).get(SELECT_MENU_INDEX);
        }
        return menuRepository.findByName(randomMenuName)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MENU_EXCEPTION_MESSAGE));
    }

    private Category findValidCategory(final List<Category> categories) {
        Category randomCategory = findRandomCategory();

        while (calculateRecommendCategory(categories, randomCategory) > MAX_DUPLICATE_LUNCH_CATEGORY) {
            randomCategory = findRandomCategory();
        }
        categories.add(randomCategory);
        return randomCategory;
    }

    private long calculateRecommendCategory(final List<Category> categories, Category category) {
        return categories.stream().filter(addCategory -> addCategory.matches(category)).count();
    }

    private Category findRandomCategory() {
        int categoryNumber = Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER, MAX_CATEGORY_NUMBER);
        return Category.findByNumber(categoryNumber);
    }
}
