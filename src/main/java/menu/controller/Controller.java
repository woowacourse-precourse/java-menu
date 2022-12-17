package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import menu.constant.Food;
import menu.domain.Coach;
import menu.domain.Recommender;
import menu.domain.vo.Name;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public void run() {
        OUTPUT_VIEW.printServiceStart();
        Recommender recommender = recommend();
        OUTPUT_VIEW.printMenus(recommender.getRecommendedCategories(), recommender.getRecommendations());
    }

    private Recommender recommend() {
        return repeat(() -> {
            Recommender recommender = new Recommender(readCoaches());
            recommender.recommend();
            return recommender;
        });
    }

    private List<Coach> readCoaches() {
        return repeat(() -> {
            List<Name> coachNames = readNames();
            List<Coach> coaches = new ArrayList<>();
            for (Name coachName : coachNames) {
                List<Food> inedibles = readInediblesOf(coachName.getName());
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

    private List<Food> readInediblesOf(String coachName) {
        return repeat(() -> INPUT_VIEW.readInediblesOf(coachName).stream()
                .filter(inedible -> !inedible.isBlank())
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
