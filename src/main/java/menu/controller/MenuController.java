package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

import static menu.util.TransformInput.splitInput;

public class MenuController {
    private List<String> initCoachNames() {
        String names = repeat(InputView::readCoachName);
        return splitInput(names);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }
}
