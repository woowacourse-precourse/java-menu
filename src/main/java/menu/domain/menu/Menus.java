package menu.domain.menu;

import java.util.List;

public class Menus {
    private final List<Menu> menus;

    private Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus of(List<Menu> menus) {
        return new Menus(menus);
    }
}
