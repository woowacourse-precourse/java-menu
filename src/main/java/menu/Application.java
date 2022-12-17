package menu;

import menu.controller.LunchMenuController;

public class Application {
    public static void main(String[] args) {

        LunchMenuController lunchMenuController = new LunchMenuController();
        lunchMenuController.start();
    }
}
