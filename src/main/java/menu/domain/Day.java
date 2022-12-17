package menu.domain;

import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.domain.menu.Food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day {
    private String day;
    private Map<Coach, String> coachMenu;

    public Day (String day) {
        this.day = day;
        coachMenu = new HashMap<>();
    }

    public static Day of(String day) {
        return new Day(day);
    }

    public String getDay() {
        return day;
    }

    public Map<Coach, String> getCoachMenu() {
        return coachMenu;
    }

    public void initCoachs(Coachs coachs) {
        for (Coach coach : coachs.getCoachs()) {
            coachMenu.put(coach, null);
        }
    }
}
