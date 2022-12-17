package menu.domain;

import menu.domain.enums.Category;
import menu.domain.enums.Weekday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Group {

    private final Map<Weekday, Category> categoryTable = new HashMap<>();
    private final List<Coach> coaches;

    public Group(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Category> categories() {
        return Weekday.weekdays().stream()
                .map(categoryTable::get)
                .collect(Collectors.toList());
    }

    public List<Coach> coaches() {
        return coaches;
    }

    public void confirmDayCategory(Weekday weekday, Category category) {
        categoryTable.put(weekday, category);
    }

    public boolean isDuplicatedCategory(Category category) {
        for (Coach coach : coaches) {
            if (coach.isDuplicatedCategory(category)) {
                return true;
            }
        }
        return false;
    }
}
