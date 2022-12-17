package menu;

import menu.configuration.AppConfig;
import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuController menuController = AppConfig.menuController();

        menuController.setCoaches();
        menuController.setAvoidance();
        menuController.recommend();
    }
}
