package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import menu.constant.Food;
import menu.domain.Coach;
import menu.domain.Recommender;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {

    private static InputView INPUT_VIEW = new InputView();
    private static OutputView OUTPUT_VIEW = new OutputView();

    public void run() {
        Recommender recommender = new Recommender(readCoaches());
        recommender.recommend();
    }

    private List<Coach> readCoaches() {
        List<String> coachNames = INPUT_VIEW.readNames();
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            List<Food> inedibles = readInedibles(coachName);
            coaches.add(new Coach(coachName, inedibles));
        }
        return coaches;
    }

    private List<Food> readInedibles(String coachName) {
        return INPUT_VIEW.readInedibleOf(coachName).stream()
                .map(Food::from)
                .collect(Collectors.toList());
    }
}
