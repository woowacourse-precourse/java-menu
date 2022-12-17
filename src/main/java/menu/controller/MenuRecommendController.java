package menu.controller;

import menu.domain.MenuRecommender;
import menu.util.RepeatValidator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommendController {

    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;

    private final OutputView outputView;
    private final InputView inputView;

    private final MenuRecommender menuRecommender;

    public MenuRecommendController() {
        outputView = new OutputView();
        inputView = new InputView();

        menuRecommender = new MenuRecommender();
    }

    public void startSuggestion() {
        outputView.printProgramStartInfo();
        addCoaches();
    }

    private void addCoaches() {
        RepeatValidator.runUntilValidate(() -> {
            List<String> coachNames = readCoachNames();
            menuRecommender.addCoaches(coachNames);
        });
    }

    private List<String> readCoachNames() {
        return inputView.readCoachNames(MIN_COACH_NUMBER, MAX_COACH_NUMBER);
    }
}
