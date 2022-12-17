package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    private static final List<Category> menuCategories = new ArrayList<>();

    public static Category saveByName(String category) {
        Category menuCategory = new Category(category);
        menuCategories.add(menuCategory);
        return menuCategory;
    }

    public static Category makeRandomCategory(int pickNumberInRange) {
        return menuCategories.get(pickNumberInRange);
    }
}
