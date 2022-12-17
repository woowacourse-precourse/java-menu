package menu.service.menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.coach.entity.Coach;
import menu.domain.coach.repository.CoachRepository;
import menu.domain.menu.Category;
import menu.domain.menu.entity.Menu;
import menu.domain.menu.repository.MenuRepository;

public class MenuService {

    private static final int MIN_CATEGORY_NUMBER = 1;
    private static final int MAX_CATEGORY_NUMBER = 5;
    private static final int SELECT_MENU_INDEX = 0;
    private static final int LUNCH_COUNT = 5;
    private static final long MAX_DUPLICATE_LUNCH_CATEGORY = 2;

    private final CoachRepository coachRepository;
    private final MenuRepository menuRepository;

    public MenuService(CoachRepository coachRepository, MenuRepository menuRepository) {
        this.coachRepository = coachRepository;
        this.menuRepository = menuRepository;
    }

    public Map<Coach, List<Menu>> recommendLunchMenu(String coachName) {
        List<Coach> coaches = coachRepository.findAll();
        Map<Coach, List<Menu>> recommendLunchMenu = new HashMap<>();

        coaches.forEach(coach -> recommendLunchMenu.put(coach, calculateRecommendLunchMenu(coach)));
        return recommendLunchMenu;
    }

    private List<Menu> calculateRecommendLunchMenu(Coach coach) {
        List<Menu> recommendMenus = new ArrayList<>();

        while (recommendMenus.size() <= LUNCH_COUNT) {
            Menu randomMenu = findRecommendMenu(recommendMenus, coach);
            processRandomMenu(recommendMenus, randomMenu);
        }
        return recommendMenus;
    }

    private void processRandomMenu(final List<Menu> recommendMenus, Menu randomMenu) {
        if (!recommendMenus.contains(randomMenu)) {
            recommendMenus.add(randomMenu);
        }
    }

    private Menu findRecommendMenu(final List<Menu> recommendMenus, Coach coach) {
        Category category = findValidCategory(recommendMenus);
        List<Menu> menus = menuRepository.findAllByCategory(category);
        Menu recommendMenu = Randoms.shuffle(menus).get(SELECT_MENU_INDEX);

        while (coach.matchesByInedibleMenu(recommendMenu)) {
            recommendMenu = Randoms.shuffle(menus).get(SELECT_MENU_INDEX);
        }
        return Randoms.shuffle(menus).get(SELECT_MENU_INDEX);
    }

    private Category findValidCategory(final List<Menu> recommendMenus) {
        Category category = findRandomCategory();
        while (calculateRecommendLunchCategory(recommendMenus, category) > MAX_DUPLICATE_LUNCH_CATEGORY) {
            category = findRandomCategory();
        }
        return category;
    }

    private Category findRandomCategory() {
        int categoryNumber = Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER, MAX_CATEGORY_NUMBER);
        return Category.findByNumber(categoryNumber);
    }

    private long calculateRecommendLunchCategory(final List<Menu> recommendMenus, Category category) {
        return recommendMenus.stream().filter(menu -> menu.matchesByCategory(category)).count();
    }
}
