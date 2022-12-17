package menu.domain;

import menu.util.MenuCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CategoryRepository {

    private static final List<MenuCategory> weekCategories = new ArrayList<>();

    public static List<MenuCategory> weekCategories() {
        return Collections.unmodifiableList(weekCategories);
    }

    public static void addToWeekCategory(MenuCategory category) {
        if (Collections.frequency(weekCategories, category) == 2) {
            throw new IllegalArgumentException();
        }
        weekCategories.add(category);
    }
}

