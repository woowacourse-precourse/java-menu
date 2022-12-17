package menu.dto.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.coach.entity.Coach;
import menu.domain.menu.entity.Menu;

public class RecommendMenusDto {

    private static final int FIRST_MENU_INDEX = 0;

    private final Map<Coach, List<Menu>> recommendMenus;

    public RecommendMenusDto(final Map<Coach, List<Menu>> recommendMenus) {
        this.recommendMenus = recommendMenus;
    }

    public Map<String, List<String>> getRecommendMenus() {
        Map<String, List<String>> recommendMenusLog = new HashMap<>();

        recommendMenus.keySet().forEach(coach ->
                recommendMenusLog.put(coach.getName(), mapToMenuName(recommendMenus.get(coach))));
        return recommendMenusLog;
    }

    private List<String> mapToMenuName(final List<Menu> menus) {
        return menus.stream().map(Menu::getName).collect(Collectors.toList());
    }

    public List<String> getRecommendCategories() {
        return recommendMenus.keySet().stream()
                .map(coach -> recommendMenus.get(coach).get(FIRST_MENU_INDEX).getName())
                .collect(Collectors.toList());
    }
}
