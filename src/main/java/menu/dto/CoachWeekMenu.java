package menu.dto;

import menu.vo.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachWeekMenu {
    private final Coach coach;
    private List<String> eatMenus;

    public CoachWeekMenu(Coach coach) {
        this.coach = coach;
        eatMenus = new ArrayList<>();
    }

    public Coach getCoach() {
        return coach;
    }

    public List<String> getEatMenus() {
        return eatMenus;
    }
}
