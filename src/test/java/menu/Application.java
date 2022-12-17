package menu;

import menu.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.execute();
    }
}
