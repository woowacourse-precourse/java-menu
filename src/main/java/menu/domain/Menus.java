package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private final List<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
    }
}
