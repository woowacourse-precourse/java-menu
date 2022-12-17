package menu;

import menu.controller.FrontController;

public class Application {

    public static void main(String[] args) {
        ApplicationConfig config = new ApplicationConfig();
        FrontController frontController = config.initFrontController();

        frontController.run();
    }
}
