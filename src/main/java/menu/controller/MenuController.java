package menu.controller;

import menu.service.MenuService;

public class MenuController {

    static MenuService menuService = new MenuService();

    public void menuChoice(){
        menuService.menuChoice();
    }

}
