package menu.domain;

import java.util.List;

public class RecommendMenus {

    private Coach coach;
    private List<String> menus;

    public RecommendMenus(Coach coach, List<String> menus) {
        this.coach = coach;
        this.menus = menus;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<String> getMenus() {
        return menus;
    }
}
