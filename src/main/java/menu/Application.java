package menu;

import menu.controller.MenuController;
import menu.service.MenuService;
import menu.utils.Converter;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    private static MenuController menuController;

    public static void main(String[] args) {
        init();
        menuController.start();
    }

    private static void init() {
        InputView inputView = new InputView(new Converter());
        OutputView outputView = new OutputView();
        MenuService menuService = new MenuService();

        menuController = new MenuController(inputView, outputView, menuService);
    }
}
