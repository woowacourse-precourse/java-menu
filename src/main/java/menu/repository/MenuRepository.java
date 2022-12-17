package menu.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.FoodCategory;
import menu.domain.Menu;

public class MenuRepository {

    private static final Map<FoodCategory, List<Menu>> store = new HashMap<>();

    public static void save(FoodCategory foodCategory, List<Menu> menus) {
        store.put(foodCategory, menus);
    }

    public static List<Menu> findByFoodCategory(FoodCategory foodCategory) {
        return store.get(foodCategory);
    }
}
