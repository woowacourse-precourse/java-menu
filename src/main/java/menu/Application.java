package menu;

import menu.controller.MenuController;
import menu.controller.MenuControllerImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuControllerImpl();
        menuController.run();
    }
}
