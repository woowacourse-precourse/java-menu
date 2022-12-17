package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MenuController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        List<String> coachNames = repeat(inputView::getCoachNames);
    }

    private <T> T repeat(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return repeat(function);
        }
    }

}
