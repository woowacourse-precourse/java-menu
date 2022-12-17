package menu.dto;

import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;

public class Recommendation {

    private final Map<Coach, Map<Day, String>> recommendation;
    private final Map<Day, Category> categories;

    public Recommendation(
            Map<Coach, Map<Day, String>> recommendation,
            Map<Day, Category> categories
    ) {
        this.recommendation = recommendation;
        this.categories = categories;
    }
}
