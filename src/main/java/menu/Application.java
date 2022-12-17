package menu;

import menu.controller.MainController;
import menu.repository.CoachRepository;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.run();
    }
}
