package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryForDay {

    private final List<String> categories;

    public CategoryForDay() {
        this.categories = new ArrayList<>();
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories() {
        while (categories.size() != 5) {
            String category = Menu.recommendCategory();

            if (Collections.frequency(categories, category) < 2) {
                categories.add(category);
            }
        }
    }

    @Override
    public String toString() {
        String totalCategory = "[ 카테고리";

        for (String category : categories) {
            totalCategory += " | " + category;
        }
        totalCategory += " ]";

        return totalCategory;
    }
}
