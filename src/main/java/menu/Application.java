package menu;

import menu.controller.MenuController;

public class Application {
    private static MenuController menuController = new MenuController();
    public static void main(String[] args) {
        menuController.startProgram();
    }
}
