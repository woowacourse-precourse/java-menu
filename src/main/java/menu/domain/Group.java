package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final List<String> categoryHistory = new ArrayList<>();

    public void makeCategory() {
        String category;
        do {
            category = Category.getRandomCategory();
        } while (Collections.frequency(categoryHistory, category) < 2);
        categoryHistory.add(category);
    }
}
