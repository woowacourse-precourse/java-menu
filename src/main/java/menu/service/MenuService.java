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

