package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommendResult {
    private final List<Day> days;
    private final List<Coach> coaches;
    private final List<Category> categories;

    public MenuRecommendResult(List<Day> days, List<Coach> coaches, List<Category> categories) {
        this.days = days;
        this.coaches = coaches;
        this.categories = categories;
    }

    public List<Day> getDays() {
        return days;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
