package menu;

import menu.controller.MenuController;
import menu.domain.MenuDomain;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuController(new InputView(), new OutputView(), new MenuDomain());
        menuController.initMenu();
        menuController.start();
    }
}
