package domain;

import java.util.List;

public class Menus {
    private final List<Menu> menuNames;

    public Menus(List<Menu> menuNames) {
        this.menuNames = menuNames;
    }

    public List<Menu> getMenuNames() {
        return menuNames;
    }
}
