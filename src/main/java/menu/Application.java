package menu;

import menu.controller.MenuController;
import menu.view.OutputView;

import java.io.IOException;

public class Application {
    private static final OutputView outputView = OutputView.getInstance();
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        try {
            menuController.run();
        } catch (IllegalArgumentException | IOException e) {
            outputView.printError(e.getMessage());
        }
    }
}
