package menu.domain;

import menu.util.MenuCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static menu.util.NumberProperty.MAX_SAME_CATEGORY;


public class CategoryRepository {

    private static final List<MenuCategory> weekCategories = new ArrayList<>();

    public static List<MenuCategory> weekCategories() {
        return Collections.unmodifiableList(weekCategories);
    }

    public static void addToWeekCategory(MenuCategory category) {
        if (Collections.frequency(weekCategories, category) == MAX_SAME_CATEGORY) {
            throw new IllegalArgumentException();
        }
        weekCategories.add(category);
    }
}

