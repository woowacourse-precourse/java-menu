package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.CategoryPicker;

public class RecommendedCategory {
    private List<String> categories;

    public RecommendedCategory() {
        this.categories = new ArrayList<>();
        pickRandomCategories();
    }

    private void pickRandomCategories() {
        while (categories.size() < 5) {
            addDailyCategory(CategoryPicker.pickCategory());
        }
    }

    private void addDailyCategory(String category) {
        if (isAbleToAdd(category)) {
            categories.add(category);
        }
    }

    private boolean isAbleToAdd(String category) {
        return (int) categories.stream()
                .filter(name -> name.equals(category))
                .count() < 2;
    }
}
