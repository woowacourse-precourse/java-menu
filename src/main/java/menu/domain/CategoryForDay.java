package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryForDay {

    private List<String> categories;

    public CategoryForDay() {
        this.categories = new ArrayList<>();
    }

    public void setCategories() {
        while (categories.size() != 5) {
            String category = Menu.recommendCategory();

            if (Collections.frequency(categories, category) < 2) {
                categories.add(category);
            }
        }
    }
}
