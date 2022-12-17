package menu.domain;

import java.util.List;

public class Menu {
    private Category category;
    private List<String> menus;

    public Menu(Category category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getMenus() {
        return menus;
    }
}
