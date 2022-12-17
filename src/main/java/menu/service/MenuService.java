package menu.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachName;
import menu.domain.utils.Picker;
import menu.service.dto.CoachNameDto;
import menu.service.dto.MenuDto;
import menu.service.dto.RecommendResultDto;

public class MenuService implements Menu {

    private static final String MENU_NOT_FOUND_MSG = "없는 메뉴입니다";

    private static final String NUMBER_OVER__MSG = "사람 수가 범위를 벗어났습니다";
    private static final int LIMIT_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private final Map<Category, List<String>> menus;
    private final Picker picker;

    public MenuService(final Map<String, List<String>> menus, final Picker picker) {
        this.menus = stringToMenuConverter(menus);
        this.picker = picker;
    }

    private Map<Category, List<String>> stringToMenuConverter(final Map<String, List<String>> input) {
        final EnumMap<Category, List<String>> categoryAndMenu = new EnumMap<>(Category.class);

        input.forEach((key, value) -> categoryAndMenu.put(Category.findCategory(key), value));
        return categoryAndMenu;
    }

    @Override
    public void validateCoachNames(final CoachNameDto coachNameDto) {
        final List<String> names = coachNameDto.getNames();
        if (names.size() >= LIMIT_COACH_COUNT && names.size() <= MAX_COACH_COUNT) {
            names.forEach(CoachName::new);
        } else {
            throw new IllegalArgumentException(NUMBER_OVER__MSG);
        }
    }

    @Override
    public void validateMenus(final MenuDto menuDto) {
        menuDto.getMenus()
                .forEach(this::validateMenu);
    }

    private void validateMenu(final String menu) {
        if (!menu.isEmpty()) {
            final boolean menuIsValid = menus.values().stream().anyMatch(it -> it.contains(menu));
            if (!menuIsValid) {
                throw new IllegalArgumentException(MENU_NOT_FOUND_MSG);
            }
        }
    }

    @Override
    public RecommendResultDto recommend(final List<String> names, final List<List<String>> notEatMenus) {
        final List<Coach> coaches = initCoaches(names, notEatMenus);
        final List<Category> categories = new ArrayList<>();
        getRecommand(coaches, categories);
        final List<String> categoriesDto = getCategoriesDto(categories);
        final List<List<String>> coachesDto = getCoachesDto(coaches);
        return RecommendResultDto.of(categoriesDto, coachesDto);
    }

    private List<List<String>> getCoachesDto(List<Coach> coaches) {
        final List<List<String>> coachesDto = new ArrayList<>();
        for (Coach coach : coaches) {
            List<String> coachToDto = coach.coachToDto();
            coachesDto.add(coachToDto);
        }
        return coachesDto;
    }

    private List<String> getCategoriesDto(List<Category> categories) {
        final List<String> categoriesDto = new ArrayList<>();
        for (Category category : categories) {
            String categoryKeyToDto = category.categoryKeyToDto();
            categoriesDto.add(categoryKeyToDto);
        }
        return categoriesDto;
    }

    private void getRecommand(List<Coach> coaches, List<Category> categories) {
        for (int i = 0; i < 5; i++) {
            recommendDay(coaches, categories);
        }
    }

    private List<Coach> initCoaches(final List<String> names, final List<List<String>> notAteMenus) {
        final List<Coach> coaches = new ArrayList<>();
        generateCoaches(names, notAteMenus, coaches);
        return coaches;
    }

    private void generateCoaches(final List<String> names, final List<List<String>> notAteMenus, final List<Coach> coaches) {
        for (int i = 0; i < names.size(); i++) {
            final String name = names.get(i);
            final List<String> notAteMenu = notAteMenus.get(i);
            coaches.add(new Coach(new CoachName(name), notAteMenu));
        }
    }

    private void recommendDay(final List<Coach> coaches, final List<Category> categories) {
        categories.add(getCategory());
        final List<String> categoryMenus = menus.get(getCategory());

        for (final Coach coach : coaches) {
            recommendDayAndCoach(coach, categoryMenus);
        }
    }

    private void recommendDayAndCoach(final Coach coach, final List<String> oneCategoryMenus) {
        while (true) {
            final String menu = getOneMenu(oneCategoryMenus);
            if (coach.canEat(menu)) {
                coach.eat(menu);
                break;
            }
        }
    }

    private String getOneMenu(final List<String> oneCategoryMenus) {
        return picker.shuffle(oneCategoryMenus).get(0);
    }

    private Category getCategory() {
        final int picked = picker.pickNumberInRange(1, 5);
        return Category.findCategory(picked);
    }

}