package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.FoodRecommender;
import menu.view.InputView;

public class MenuController {
    private final InputView inputView;

    public MenuController() {
        inputView = new InputView();
    }

    public void run() {
        List<Coach> coaches = inputView.readCoaches()
                .stream()
                .map(Coach::new)
                .collect(Collectors.toList());
        FoodRecommender recommender = new FoodRecommender(coaches);

        for (Coach coach : coaches) {
            coach.setBlacklist(inputView.readBlackList(coach));
        }
    }
}
