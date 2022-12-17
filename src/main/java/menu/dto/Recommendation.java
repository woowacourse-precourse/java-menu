package menu.dto;

import java.util.Map;
import menu.domain.Coach;
import menu.domain.Day;

public class Recommendation {

    private final Map<Coach, Map<Day, String>> recommendation;

    public Recommendation(Map<Coach, Map<Day, String>> recommendation) {
        this.recommendation = recommendation;
    }
}
