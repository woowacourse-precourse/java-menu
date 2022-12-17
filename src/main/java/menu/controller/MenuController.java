package menu.controller;

import menu.utls.Validator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;

    public MenuController() {
        outputView = new OutputView();
        inputView = new InputView();
        validator = new Validator();
    }

    public void run() {
        outputView.outputStartNotice();
        inputCoachNames();
    }

    private String inputCoachNames() {
        try {
            String input = inputView.inputCoachNames();
            validator.validateCoachNames(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputCoachNames();
        }
    }
}
