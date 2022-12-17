package menu.domain;

import java.util.List;

public class Menu {

    private Category category;
    private List<String> menuList;

    public Menu(Category category, List<String> menuList) {
        this.category = category;
        this.menuList = menuList;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getMenuList() {
        return menuList;
    }
}
