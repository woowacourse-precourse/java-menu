package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    public static final List<Category> categories = new ArrayList<>();

    public static void addCategory(Category category) {
        categories.add(category);
    }

    public static boolean isExistFoodInAllCategories(String foodName) {
        for (Category category : categories) {
            if (category.isExistFood(foodName)) {
                return true;
            }
        }

        return false;
    }
}
