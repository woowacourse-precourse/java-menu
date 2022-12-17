package menu.di;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.CategoryPicker;
import menu.domain.Coach;
import menu.domain.CoachName;
import menu.domain.Picker;

public class MenuUseCaseImpl implements MenuUseCase {

    private static final String MENU_NOT_FOUND_MESSAGE = "없는 메뉴입니다";
    private static final String NUMBER_OVER_RANGE_MESSAGE = "사람 수가 범위를 벗어났습니다";
    private static final int MINIMUM_COACH_COUNT = 2;
    private static final int MAXIMUM_COACH_COUNT = 5;
    private final Map<Category, List<String>> menus;
    private final Picker picker;

    public MenuUseCaseImpl(Map<String, List<String>> menus, Picker picker) {
        this.menus = toMenus(menus);
        this.picker = picker;
    }

    private Map<Category, List<String>> toMenus(Map<String, List<String>> input) {
        EnumMap<Category, List<String>> categorizedMenus = new EnumMap<>(Category.class);

        input.forEach((key, value) -> categorizedMenus.put(Category.from(key), value));
        return categorizedMenus;
    }

    @Override
    public void validateNames(ValidateNameCommand validateNameCommand) {
        List<String> names = validateNameCommand.getNames();
        if (names.size() < MINIMUM_COACH_COUNT || names.size() > MAXIMUM_COACH_COUNT) {
            throw new IllegalArgumentException(NUMBER_OVER_RANGE_MESSAGE);
        }
        names.forEach(CoachName::new);
    }


    @Override
    public void validateMenus(ValidateMenuCommand validateMenuCommand) {
        validateMenuCommand.getMenus()
                .forEach(this::validateMenu);
    }

    private void validateMenu(String menu) {
        if (menu.length() == 0) {
            return;
        }
        boolean menuIsValid = menus.values().stream().anyMatch(it -> it.contains(menu));
        if (!menuIsValid) {
            throw new IllegalArgumentException(MENU_NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public RecommendResultDto recommend(List<String> names, List<List<String>> notEatMenus) {
        List<Coach> coaches = generateCoaches(names, notEatMenus);
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            recommendOneDay(coaches, categories);
        }
        List<String> categoriesDto = categories.stream()
                .map(Category::toDto)
                .collect(Collectors.toList());
        List<List<String>> coachesDto = coaches.stream()
                .map(Coach::toDto)
                .collect(Collectors.toList());
        return new RecommendResultDto(categoriesDto, coachesDto);
    }

    private List<Coach> generateCoaches(List<String> names, List<List<String>> notEatMenus) {
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            List<String> notEatMenu = notEatMenus.get(i);
            coaches.add(new Coach(new CoachName(name), notEatMenu));
        }
        return coaches;
    }

    private void recommendOneDay(List<Coach> coaches, List<Category> categories) {
        Category picked = new CategoryPicker(picker).pickCategory();
        categories.add(picked);
        List<String> oneCategoryMenus = menus.get(picked);
        for (Coach coach : coaches) {
            recommendOneDayOneCoach(coach, oneCategoryMenus);
        }
    }

    private void recommendOneDayOneCoach(Coach coach, List<String> oneCategoryMenus) {
        while (true) {
            String menu = getOneMenu(oneCategoryMenus);
            if (coach.canEat(menu)) {
                coach.eat(menu);
                break;
            }
        }
    }

    private String getOneMenu(List<String> oneCategoryMenus) {
        return picker.shuffle(oneCategoryMenus).get(0);
    }


}
