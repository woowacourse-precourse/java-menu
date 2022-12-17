package menu.model;

import java.util.List;

public class RecommendResult {
    private final Coach coach;
    private final Menus menus;

    public RecommendResult(final Coach coach, final Menus menus) {
        this.coach = coach;
        this.menus = menus;
    }

    public String getCoachName() {
        return coach.getName();
    }

    public List<String> getMenus() {
        return menus.getMenus();
    }
}
