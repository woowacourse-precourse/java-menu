package menu.controller;

import menu.util.RepeatValidator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommendController {

    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;

    private final OutputView outputView;
    private final InputView inputView;

    public MenuRecommendController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void startSuggestion() {
        outputView.printProgramStartInfo();
        readCoachNames();
    }

    private List<String> readCoachNames() {
        return RepeatValidator.readUntilValidate(() -> {
            return inputView.readCoachNames(MIN_COACH_NUMBER, MAX_COACH_NUMBER);
        });
    }
}
