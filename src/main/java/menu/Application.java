package menu;

import menu.controller.MenuController;
import menu.service.CoachService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuController(new CoachService());
        menuController.start();
    }
}
