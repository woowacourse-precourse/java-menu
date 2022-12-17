package menu.controller;

import menu.dto.CouchNamesRequest;
import menu.service.MenuService;
import menu.view.MenuView;

public class MenuController {
    private final MenuService menuService;
    private final MenuView menuView;

    public MenuController(MenuService menuService, MenuView menuView) {
        this.menuService = menuService;
        this.menuView = menuView;
    }

    public void start() {
        menuView.printStartMessage();
        menuView.receiveCouches();
    }
}
