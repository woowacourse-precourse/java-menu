package menu;

import menu.controller.MenuController;

public class Application {

    static MenuController menuController = new MenuController();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        menuController.menuChoice();
    }
}
