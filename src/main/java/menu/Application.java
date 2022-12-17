package menu;

import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.run();
    }
}
