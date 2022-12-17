package menu.domain;

import java.util.List;

public class Menus {

    private final Category category;
    private final List<Menu> menus;

    public Menus(Category category, List<Menu> menus) {
        this.category = category;
        this.menus = menus;
    }
}
