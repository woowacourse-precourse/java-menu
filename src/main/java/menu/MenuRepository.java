package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Menu;

public class MenuRepository {

    private static Map<Category, List<Menu>> categoryMenuMap = new HashMap<>();

    public static List<Menu> getMenusByCategory(Category category) {
        return categoryMenuMap.get(category);
    }

    public static void addMenu(Menu menu) {
        categoryMenuMap.get(menu.getCategory()).add(menu);
    }
}
