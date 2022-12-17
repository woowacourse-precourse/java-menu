package menu.domain;

import java.util.List;

public class Category {

    private final String category;
    private final List<String> menus;

    public Category(String category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getMenus() {
        return menus;
    }
}
