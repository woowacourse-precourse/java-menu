package menu;

import menu.controller.MenuController;
import menu.repository.CouchRepository;
import menu.repository.MenuRepository;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.MenuView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuView menuView = new MenuView(new InputView(), new OutputView());
        MenuService menuService = new MenuService(new MenuRepository(), new CouchRepository());
        MenuController menuController = new MenuController(menuService, menuView);
        menuController.start();
    }
}
