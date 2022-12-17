package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final List<String> categoryHistory = new ArrayList<>();
    private final List<Coach> coaches = new ArrayList<>();

    public void makeCategory() {
        String category;
        do {
            category = Category.getRandomCategory();
        } while (Collections.frequency(categoryHistory, category) < 2);
        categoryHistory.add(category);
    }

    public void addCoach(String name, List<String> cannotEatMenus) {
        coaches.add(new Coach(name, cannotEatMenus));
    }
}
