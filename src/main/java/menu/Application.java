package menu;

import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuController controller = new MenuController();
        controller.start();
    }
}
