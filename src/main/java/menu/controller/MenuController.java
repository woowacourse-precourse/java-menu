package menu.controller;

import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void run() {
        inputCoachName();
        inputUnavailableMenu();
        recommendMenus();
    }

    private void inputCoachName() {

    }

    private void inputUnavailableMenu() {

    }

    private void recommendMenus() {

    }
}
