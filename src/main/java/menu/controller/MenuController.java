package menu.controller;

import menu.util.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            InputValidator.validateCoach(inputView.inputCoach());
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
        }
    }
}
