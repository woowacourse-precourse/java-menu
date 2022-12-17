package menu.configuration;

import menu.controller.MenuController;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {
    public static MenuController menuController() {
        return new MenuController(
                new MenuService(),
                new InputView(),
                new OutputView()
        );
    }
}
