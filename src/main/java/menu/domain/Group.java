package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final List<String> categoryHistory = new ArrayList<>();

    public void makeCategory() {
        String category = Category.getRandomCategory();
        categoryHistory.add(category);
    }
}
