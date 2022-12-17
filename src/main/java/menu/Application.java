package menu;

import static menu.config.AppConfig.coachService;
import static menu.config.AppConfig.menuService;

import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuController(menuService(), coachService());
        menuController.run();
    }
}
