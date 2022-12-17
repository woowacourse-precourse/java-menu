package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    public static List<Menu> getMenus() {
        return menus;
    }

    public static void addMenu(Menu menu) {
        menus.add(menu);
    }
}
