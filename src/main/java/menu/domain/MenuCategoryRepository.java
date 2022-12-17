package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuCategoryRepository {

    private static final List<MenuCategory> menuCategories = new ArrayList<>();

    public static MenuCategory saveByName(String category) {
        MenuCategory menuCategory = new MenuCategory(category);
        menuCategories.add(menuCategory);
        return menuCategory;
    }
}
