package menu;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private final String name;
    private final List<Menu> menus = new ArrayList<>();

    public Category(ValidCategories validCategory) {
        this.name = validCategory.getKorean();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public String getName() {
        return name;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
