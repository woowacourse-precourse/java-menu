package menu.repository;

import menu.domain.menucategory.MenuCategory;

import java.util.ArrayList;
import java.util.List;

public class RecommendCategoryRepository {
    private final static List<MenuCategory> menuCategories = new ArrayList<>();

    public static void addCategory(MenuCategory category) {
        menuCategories.add(category);
    }

    public static List<MenuCategory> getMenuCategories() {
        return menuCategories;
    }
}
