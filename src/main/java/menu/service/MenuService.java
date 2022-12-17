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
