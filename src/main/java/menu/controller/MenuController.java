package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachFoodRecommand;
import menu.domain.NotEatableFood;
import menu.domain.RecommandMachine;

import java.util.ArrayList;
import java.util.List;

import static menu.domain.Coach.makeCoach;
import static menu.view.InputView.*;
import static menu.view.OutputView.*;

public class MenuController {

    private final RecommandMachine recommandMachine;

    public MenuController() {
        this.recommandMachine = new RecommandMachine();
    }

    public void start() {
        try {
            List<Coach> coaches = init();
            List<CoachFoodRecommand> foodRecommands = recommandMachine.recommand(coaches);

        } catch (IllegalArgumentException error) {
            printErrorMessage(error.getMessage());
        }
    }

    private List<Coach> init() {
        printStartMessage();
        return createCoaches();
    }

    private List<Coach> createCoaches() {
        List<Coach> coaches = new ArrayList<>();
        List<String> coachNames = getCoachName();
        for (String name : coachNames) {
            coaches.add(createEachCoach(name));
        }
        return coaches;
    }

    private Coach createEachCoach(String name) {
        NotEatableFood notEatableFood = getNotEatableFood(name);
        return makeCoach(name, notEatableFood);
    }
}
