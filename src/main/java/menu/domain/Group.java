package menu.domain;

import menu.domain.enums.Category;
import menu.domain.enums.Weekday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {

    private final Map<Weekday, Category> categoryTable = new HashMap<>();
    private final List<Category> categories = new ArrayList<>();
    private final List<Coach> coaches;

    public Group(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Category> categories() {
        return categories;
    }

    public List<Coach> coaches() {
        return coaches;
    }

    public void confirmDayCategory(Weekday weekday, Category category) {
        categoryTable.put(weekday, category);
        categories.add(category);
    }
}
