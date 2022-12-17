package menu.controller;

import menu.service.MenuService;
import menu.util.Retry;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void run() {
        outputView.printStart();
        String coachNames = Retry.execute(inputView::readCoachNames);
        menuService.saveCoach(coachNames);

    }
}
