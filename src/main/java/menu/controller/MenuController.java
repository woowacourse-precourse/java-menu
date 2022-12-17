package menu.controller;

import menu.service.MenuService;
import menu.util.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MenuService menuService = new MenuService();

    public void run() {
        try {
            requestInputCoach();
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
        }
    }

    private void requestInputCoach() {
        menuService.saveCoach(InputValidator.validateCoach(inputView.inputCoach()));
    }
}
