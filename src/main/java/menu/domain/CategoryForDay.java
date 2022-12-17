package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryForDay {

    private static final int MAXIMUM_SIZE_OF_CATEGORY = 5;
    private static final int MAXIMUM_FREQUENCY_OF_CATEGORY = 2;

    private final List<String> categories;

    public CategoryForDay() {
        this.categories = new ArrayList<>();
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories() {
        while (categories.size() != MAXIMUM_SIZE_OF_CATEGORY) {
            String category = Menu.recommendCategory();
            checkCategoryFrequency(category);
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

    private void checkCategoryFrequency(String category) {
        if (Collections.frequency(categories, category) < MAXIMUM_FREQUENCY_OF_CATEGORY) {
            categories.add(category);
        }
    }
}
