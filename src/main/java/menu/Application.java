package menu;

import menu.controller.MainController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            MainController mainController = new MainController(InputView.getInstance(), OutputView.getInstance());
            mainController.service();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
