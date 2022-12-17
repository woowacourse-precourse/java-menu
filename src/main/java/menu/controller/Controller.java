package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import menu.constant.Food;
import menu.domain.Coach;
import menu.domain.Name;
import menu.domain.Recommender;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public void run() {
        OUTPUT_VIEW.printServiceStart();
        List<Coach> coaches = readCoaches();
        Recommender recommender = new Recommender(coaches);
        recommender.recommend();
        OUTPUT_VIEW.printMenus(recommender.getRecommendedCategories(), coaches);
    }

    private List<Coach> readCoaches() {
        return repeat(() -> {
            List<Name> coachNames = readNames();
            List<Coach> coaches = new ArrayList<>();
            for (Name coachName : coachNames) {
                List<Food> inedibles = readInedibles(coachName.getName());
                coaches.add(new Coach(coachName, inedibles));
            }
            return coaches;
        });
    }

    private List<Name> readNames() {
        return repeat(() -> INPUT_VIEW.readNames().stream()
                .map(Name::new)
                .collect(Collectors.toList()));
    }

    private List<Food> readInedibles(String coachName) {
        return repeat(() -> INPUT_VIEW.readInedibleOf(coachName).stream()
                .filter(String::isBlank)
                .map(Food::from)
                .collect(Collectors.toList()));
    }

    private <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OUTPUT_VIEW.printError(e.getMessage());
            return repeat(supplier);
        }
    }
}
