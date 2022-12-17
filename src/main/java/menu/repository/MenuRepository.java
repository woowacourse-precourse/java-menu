package menu.repository;

import menu.domain.Category;
import menu.domain.Menus;

import java.util.EnumMap;

public class MenuRepository {
    private EnumMap<Category, Menus> menus = new EnumMap<>(Category.class);

    public void addMenus(Category category, Menus menus) {
        this.menus.put(category, menus);
    }
}
