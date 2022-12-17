package menu.controller;

import menu.domain.Coach;
import menu.domain.MenuRecommender;
import menu.util.RepeatValidator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommendController {

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
        addUneatableFoodToCoaches();
    }

    private void addCoaches() {
        RepeatValidator.runUntilValidate(() -> {
            List<String> coachNames = readCoachNames();
            menuRecommender.addCoaches(coachNames);
        });
    }

    private List<String> readCoachNames() {
        return inputView.readCoachNames(menuRecommender.getMinCoachNumber(), menuRecommender.getMaxCoachNumber());
    }

    private void addUneatableFoodToCoaches() {
        for (Coach coach : menuRecommender.getCoaches()) {
            List<String> foods = readUneatableFoods(coach);
            coach.addUneatableFoods(foods);
        }
    }

    private List<String> readUneatableFoods(Coach coach) {
        return RepeatValidator.readUntilValidate(() -> {
            return inputView.readUneatableFoodOf(coach.getName(),
                    coach.getMinUneatableFoodCount(), coach.getMaxUneatableFoodCount());
        });
    }
}
