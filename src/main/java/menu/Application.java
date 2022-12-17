package menu;

import menu.controller.ServiceController;

public class Application {
    public static void main(String[] args) {
        ServiceController serviceController = new ServiceController();
        serviceController.run();
    }
}
