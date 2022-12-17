package menu;

import menu.controller.MainController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(new InputView(), new OutputView());
        mainController.runMain();
    }
}
