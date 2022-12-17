package menu;

import menu.controller.MenuDecideController;
import menu.utils.InitDB;

public class Application {
    public static void main(String[] args) {
        InitDB.init();
        MenuDecideController controller = new MenuDecideController();
        controller.run();
    }
}
