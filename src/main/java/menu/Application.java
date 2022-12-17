package menu;

import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MenuController menuController = new MenuController(inputView, outputView);
        menuController.run();
    }
}
