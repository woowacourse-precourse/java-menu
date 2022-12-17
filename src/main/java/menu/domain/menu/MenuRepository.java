package menu.domain.menu;

import menu.domain.category.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {
    private final static Map<Category, List<String>> menusByCategory = new HashMap<>();

    private MenuRepository() {
    }

    private static final MenuRepository instance = new MenuRepository();

    public static MenuRepository getInstance() {
        return instance;
    }


    public void save(Category category, String menu) {
        if (!menusByCategory.containsKey(category)) {
            menusByCategory.put(category, new ArrayList<>());
        }
        menusByCategory.get(category)
                .add(menu);
    }

    public List<String> findAllByCategory(Category category) {
        return menusByCategory.get(category);
    }

}
