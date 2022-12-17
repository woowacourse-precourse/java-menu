package menu.controller;

import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.function.Supplier;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private Coaches coaches;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.startMessage();
        coaches = getCoachesName();
        getNotEatableName(coaches);
    }

    public Coaches getCoachesName() {
        outputView.getCoachesName();
        return repeat(inputView::getCoachesName);
    }

    public void getNotEatableName(Coaches coaches) {
        inputView.getNotEatableMenu(coaches);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }
}
