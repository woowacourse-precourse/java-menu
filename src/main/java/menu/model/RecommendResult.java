package menu.model;

import java.util.List;
import java.util.stream.Collectors;

public class RecommendResult {
    private final Coach coach;
    private final List<Menu> menus;

    public RecommendResult(final Coach coach, final List<Menu> menus) {
        this.coach = coach;
        this.menus = menus;
    }

    public String getCoachName() {
        return coach.getName();
    }

    public List<String> getMenuNames() {
        return menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
    }
}
