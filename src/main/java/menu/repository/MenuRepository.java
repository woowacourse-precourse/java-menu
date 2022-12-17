package menu.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Category;

public class MenuRepository {

    private static final Map<Category, List<String>> menus = new HashMap<>();

    public static void addMenu(Category category, String menu) {
        processExistCategory(category, menu);
        processNotExistCategory(category, menu);
    }

    private static void processExistCategory(Category category, String menu) {
        if (menus.containsKey(category)) {
            List<String> menuNames = menus.get(category);
            storeMenu(menu, menuNames);
        }
    }

    private static void storeMenu(String menu, List<String> menuNames) {
        if (!menuNames.contains(menu)) {
            menuNames.add(menu);
        }
    }

    private static void processNotExistCategory(Category category, String menu) {
        if (!menus.containsKey(category)) {
            menus.put(category, new ArrayList<>(List.of(menu)));
        }
    }
}
