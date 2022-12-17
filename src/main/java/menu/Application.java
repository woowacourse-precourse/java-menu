package menu;

import menu.controller.MenuDecideController;

public class Application {
    public static void main(String[] args) {
        MenuDecideController controller = new MenuDecideController();
        controller.run();
    }
}
