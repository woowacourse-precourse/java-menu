package menu.di;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachName;
import menu.domain.Picker;
import menu.domain.Recommender;

public class MenuUseCaseImpl implements MenuUseCase {

    private static final String MENU_NOT_FOUND_MESSAGE = "없는 메뉴입니다";
    private static final String NUMBER_OVER_RANGE_MESSAGE = "사람 수가 범위를 벗어났습니다";
    private static final int MINIMUM_COACH_COUNT = 2;
    private static final int MAXIMUM_COACH_COUNT = 5;
    private static final int COACH_CANNOT_EAT_COUNT_START = 0;
    private static final int COACH_CANNOT_EAT_COUNT_END = 2;
    private static final String COACH_CANNOT_EAT_ERROR_MESSAGE = "먹지 못하는 음식으로 등록할 수 있는 범위를 벗어났습니다";
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
        List<String> cannotEatMenu = validateMenuCommand.getMenus();
        if (COACH_CANNOT_EAT_COUNT_START > cannotEatMenu.size() || cannotEatMenu.size() > COACH_CANNOT_EAT_COUNT_END) {
            throw new IllegalArgumentException(COACH_CANNOT_EAT_ERROR_MESSAGE);
        }
        cannotEatMenu.forEach(this::validateMenu);
    }

    private void validateMenu(String menu) {
        boolean menuIsValid = menus.values().stream().anyMatch(it -> it.contains(menu));
        if (!menuIsValid) {
            throw new IllegalArgumentException(MENU_NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public RecommendResultDto recommend(List<String> names, List<List<String>> notEatMenus) {
        List<Coach> coaches = new CoachMapper(names, notEatMenus).toCoach();
        List<Category> categories = new ArrayList<>();
        new Recommender(categories, menus, picker).recommendTimes(coaches);
        List<String> categoriesDto = categories.stream()
                .map(Category::toDto)
                .collect(Collectors.toList());
        List<List<String>> coachesDto = coaches.stream()
                .map(Coach::toDto)
                .collect(Collectors.toList());
        return new RecommendResultDto(categoriesDto, coachesDto);
    }
}
