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

    public MenuController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printStart();
        List<Coach> coaches = inputView.readCoaches()
                .stream()
                .map(Coach::new)
                .collect(Collectors.toList());
        FoodRecommender recommender = new FoodRecommender(coaches);

        for (Coach coach : coaches) {
            coach.setBlacklist(inputView.readBlackList(coach));
        }
        MenuResult menuResult = recommender.recommendByDay();
        outputView.printResult(menuResult);
    }
}
