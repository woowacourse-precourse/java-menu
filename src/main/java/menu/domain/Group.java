package menu.domain;

import menu.domain.enums.Category;
import menu.domain.enums.Weekday;

import java.util.ArrayList;
import java.util.List;

public class Group {

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
        categories.add(category);
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
