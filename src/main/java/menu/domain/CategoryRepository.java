package menu.domain;

import menu.domain.food.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    public static final int MAXIMUM_COUNT = 2;
    public static final int INIT = 0;
    private static List<Category> categories = new ArrayList<>();

    public static void save(Category category) {
        categories.add(category);
    }

    public static boolean hasSameCategoryMoreThanTwo(Category targetCategory) {
        int count = INIT;

        for (Category category : categories) {
            if (category.isSameCategory(targetCategory)) {
                count++;
            }
        }

        return count > MAXIMUM_COUNT;
    }
}
