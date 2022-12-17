package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.CategoryPicker;

public class RecommendedCategory {
    private List<String> categories;

    public RecommendedCategory() {
        this.categories = new ArrayList<>();
    }

    public List<String> getCategories() {
        return categories;
    }

    public String pickRandomCategory() {
        return addDailyCategory();
    }

    private String addDailyCategory() {
        String category;
        while (true) {
            category = CategoryPicker.pickCategory();
            if (isAbleToAdd(category)) {
                categories.add(category);
                return category;
            }
        }
    }

    private boolean isAbleToAdd(String category) {
        return (int) categories.stream()
                .filter(name -> name.equals(category))
                .count() < 2;
    }
}
