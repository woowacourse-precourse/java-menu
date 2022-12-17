package menu.repository;

import menu.domain.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {

    private Map<Category, List<String>> menuStorages = new HashMap<>();

    public void saveCategoryAndMenu(Category category, List<String> menuNames) {
        menuStorages.put(category, menuNames);
    }

    public List<String> findMenusByCategory(Category findCategory) {
        return menuStorages.get(findCategory);
    }
}
