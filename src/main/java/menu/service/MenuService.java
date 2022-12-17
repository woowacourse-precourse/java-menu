package menu.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachMapper;
import menu.domain.CoachName;
import menu.domain.utils.CategoryPicker;
import menu.domain.utils.pick;
import menu.service.dto.CoachNameDto;
import menu.service.dto.MenuDto;
import menu.service.dto.RecommendResultDto;

public class MenuService implements Menu {

    private static final String MENU_NOT_FOUND_MSG = "없는 메뉴입니다";
    private static final String NUMBER_OVER__MSG = "사람 수가 범위를 벗어났습니다";
    private static final int LIMIT_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final int COACH_CANNOT_EAT_COUNT_END = 2;
    private static final int MAX_SAME_CATEGORY = 2;
    private static final String COACH_CANNOT_EAT_ERROR_MSG = "등록할 수 있는 범위를 벗어났습니다";
    private static final int PICK_DATE_SIZE = 5;
    private final Map<Category, List<String>> menus;
    private final pick pick;

    public MenuService(final Map<String, List<String>> menus, final pick pick) {
        this.menus = stringToMenuConverter(menus);
        this.pick = pick;
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
            names.forEach(CoachName::of);
        } else {
            throw new IllegalArgumentException(NUMBER_OVER__MSG);
        }
    }


    @Override
    public void validateMenus(final MenuDto coachNameDto) {
        final List<String> notAteMenu = coachNameDto.getMenus();
        if (notAteMenu.size() > COACH_CANNOT_EAT_COUNT_END) {
            throw new IllegalArgumentException(COACH_CANNOT_EAT_ERROR_MSG);
        }
        notAteMenu.forEach(this::validateMenu);
    }

    private void validateMenu(final String menu) {
        final boolean menuIsValid = menus.values().stream().
                anyMatch(e -> e.contains(menu));
        if (!menuIsValid) {
            throw new IllegalArgumentException(MENU_NOT_FOUND_MSG);
        }
    }

    @Override
    public RecommendResultDto recommend(final List<String> names, final List<List<String>> notEatMenus) {
        final List<Coach> coaches = new CoachMapper(names, notEatMenus).mapToCoach();
        final List<Category> categories = new ArrayList<>();
        for (int i = 0; i < PICK_DATE_SIZE; i++) {
            recommendDay(coaches, categories);
        }
        final List<String> categoriesDto = getCategoriesDto(categories);
        final List<List<String>> coachesDto = getCoachesDto(coaches);
        return RecommendResultDto.of(categoriesDto, coachesDto);
    }

    private List<List<String>> getCoachesDto(final List<Coach> coaches) {
        final List<List<String>> coachesDto = new ArrayList<>();
        for (final Coach coach : coaches) {
            final List<String> coachToDto = coach.coachToDto();
            coachesDto.add(coachToDto);
        }
        return coachesDto;
    }

    private List<String> getCategoriesDto(final List<Category> categories) {
        final List<String> categoriesDto = new ArrayList<>();
        for (final Category category : categories) {
            final String categoryKeyToDto = category.categoryKeyToDto();
            categoriesDto.add(categoryKeyToDto);
        }
        return categoriesDto;
    }

    private void recommendDay(final List<Coach> coaches, final List<Category> categories) {
        final Category picked = pickCategory(categories);
        final List<String> oneCategoryMenus = menus.get(picked);
        for (final Coach coach : coaches) {
            recommendDayCoach(coach, oneCategoryMenus);
        }
    }

    private Category pickCategory(final List<Category> alreadyPicked) {
        while (true) {
            final Category newCategory = new CategoryPicker(pick).pickCategory();
            if (canPickCategory(alreadyPicked, newCategory)) {
                alreadyPicked.add(newCategory);
                return newCategory;
            }
        }
    }

    private boolean canPickCategory(final List<Category> picked, final Category newCategory) {
        return picked.stream()
                .filter(it -> it == newCategory)
                .count() < MAX_SAME_CATEGORY;
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
        return pick.shuffle(oneCategoryMenus).get(0);
    }
}