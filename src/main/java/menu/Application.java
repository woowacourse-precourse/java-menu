package menu;

import menu.controller.MenuController;
import menu.service.MenuService;

public class Application {
    public static void main(String[] args) {
        MenuController menuController = new MenuController(new MenuService());

        menuController.run();
    }
}
