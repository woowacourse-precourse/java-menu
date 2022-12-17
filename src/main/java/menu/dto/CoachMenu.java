package menu.dto;

import menu.vo.Coach;

public class CoachMenu {
    private final Coach coach;
    private final String menu;

    public CoachMenu(Coach coach, String menu) {
        this.coach = coach;
        this.menu = menu;
    }

    public Coach getCoach() {
        return coach;
    }

    public String getMenu() {
        return menu;
    }
}
