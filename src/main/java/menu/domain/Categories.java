package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.domain.menu.FoodStyle;

public class Categories {
    private final static int MAX_CATEGORIES_SIZE = 2;
    private List<String> categories;

    public Categories() {
        this.categories = new ArrayList<>();
    }

    public List<String> getCategories() {
        return categories;
    }

    public void addCategory(String categoryName) {
        this.categories.add(categoryName);
    }

    public boolean isFullOfCategory(FoodStyle foodStyle) {
        long count = categories.stream()
                .filter(category -> category.equals(foodStyle.getStyle()))
                .count();
        if (count >= MAX_CATEGORIES_SIZE) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String category : categories) {
            sb.append("| " + category + " ");
        }
        return sb.toString();
    }
}
