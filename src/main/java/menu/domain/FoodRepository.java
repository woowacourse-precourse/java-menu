package menu.domain;

import menu.domain.food.Category;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FoodRepository {

    private static Map<Category, List<String>> menu = new LinkedHashMap<>();

    public static void addMenu(Category category, List<String> menus) {
        menu.put(category, menus);
    }

    public static List<String> getMenus(Category category) {
        return menu.get(category);
    }

    public static boolean hasFoodName(String foodName) {
        for(Category category : menu.keySet()) {
            List<String> foods = menu.get(category);
            if (isMenu(foodName, foods)) return true;
        }

        return false;
    }

    private static boolean isMenu(String foodName, List<String> foods) {
        for(String food : foods) {
            if(food.equals(foodName)) {
                return true;
            }
        }
        return false;
    }
}
