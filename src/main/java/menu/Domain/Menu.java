package menu.Domain;

import java.util.List;

public class Menu {

    private List<String> menus;
    private String category;

    public Menu(String category, List<String> menus) {
        this.menus = menus;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getMenus() {
        return menus;
    }
}
