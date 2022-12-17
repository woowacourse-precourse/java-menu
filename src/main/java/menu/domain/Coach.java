package menu.domain;

import java.util.ArrayList;

public class Coach {
    private final String name;
    private final Menus hateMenus;
    private final Menus recommended;

    public Coach(String name) {
        this.name = name;
        this.hateMenus = new Menus();
        this.recommended = new Menus();
    }

    public void addHateMenu(Menu menu) {
        hateMenus.addMenu(menu);
    }
}
