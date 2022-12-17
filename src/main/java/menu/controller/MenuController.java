package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.FoodRecommender;
import menu.domain.MenuResult;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private FoodRecommender recommender;

    public MenuController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printStart();
        List<Coach> coaches = getCoaches();
        for (Coach coach : coaches) {
            addBlacklist(coach);
        }
        MenuResult menuResult = recommender.recommendByDay();
        outputView.printResult(menuResult);
    }

    private void addBlacklist(Coach coach) {
        try {
            coach.setBlacklist(inputView.readBlackList(coach));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            addBlacklist(coach);
        }
    }

    private List<Coach> getCoaches() {
        try {
            List<Coach> coaches = readCoaches();
            recommender = new FoodRecommender(coaches);
            return coaches;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getCoaches();
        }
    }

    private List<Coach> readCoaches() {
        return inputView.readCoaches()
                .stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }
}
