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
            requestInputExcludeMenu(coaches, 1);
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            run();
        }
    }

    private void requestInputExcludeMenu(final Coaches coaches, final int count) {
        if (coaches.isCoachesCount(count - 1)) {
            return;
        }
        try {
            menuService.saveExcludeMenu(inputView.inputExcludeMenu(coaches, count));
            requestInputExcludeMenu(coaches, count + 1);
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestInputExcludeMenu(coaches, count);
        }
    }

    private Coaches requestInputCoach() {
        return menuService.saveCoach(validateCoach(inputView.inputCoach()));
    }
}
