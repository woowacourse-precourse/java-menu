package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryRepository {
    private static final List<Category> categories = new ArrayList<>();

    public static List<Category> categories() {
        return Collections.unmodifiableList(categories);
    }

    public static void addCategory(Category category) {
        categories.add(category);
    }

    public static void deleteAll() {
        categories.clear();
    }

    public static Category getCategoryByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    public static boolean contains(String name) {
        return categories.contains(getCategoryByName(name));
    }
}
