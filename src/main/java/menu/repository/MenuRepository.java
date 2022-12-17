package menu.repository;

import menu.domain.Category;
import menu.domain.Menus;

import java.util.EnumMap;

public class MenuRepository {
    private static EnumMap<Category, Menus> menus = new EnumMap<>(Category.class);

    public void addMenus(Category category, Menus menus) {
        this.menus.put(category, menus);
    }

    public boolean isExistsMenu(String name) {
        return menus.keySet().stream()
                .anyMatch(key -> menus.get(key).hasMenu(name));
    }

    public Menus findByCategory(Category category) {
        return menus.get(category);
    }
}
