package menu.repository;

import java.util.EnumMap;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Menus;

public class MenuRepository {

    private final Map<Category, Menus> repository = new EnumMap<>(Category.class);

    public MenuRepository() {
    }

    public void save(Category category, Menus menus) {
        repository.put(category, menus);
    }
}
