package menu.domain;

import menu.domain.coach.Coach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day {
    private String day;
    private Map<String, List<String>> coachMenu;

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
}
