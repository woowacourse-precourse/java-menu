package menu.controller;

import static menu.util.InputValidator.validateCoach;

import menu.domain.Coaches;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MenuService menuService = new MenuService();

    public void run() {
        try {
            Coaches coaches = requestInputCoach();
            requestInputExcludeMenu(coaches);
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
        }
    }

    private void requestInputExcludeMenu(final Coaches coaches) {
        try {
            inputView.inputExcludeMenu(coaches);
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestInputExcludeMenu(coaches);
        }
    }

    private Coaches requestInputCoach() {
        return menuService.saveCoach(validateCoach(inputView.inputCoach()));
    }
}
