package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<String> readValidCoachNames() {
        return repeatUntilGettingValidValue(this::readCoachNames);
    }

    private List<String> readCoachNames() {
        outputView.printCoachNameInputGuide();
        return inputView.readCoachNames();
    }

    private <T> T repeatUntilGettingValidValue(Supplier<T> getSomething) {
        while (true) {
            try {
                return getSomething.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
