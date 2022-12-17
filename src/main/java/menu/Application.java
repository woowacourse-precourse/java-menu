package menu;

import menu.controller.MenuController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        MenuController menuController = new MenuController(inputView, outputView);
        menuController.init();
    }
}
