package menu.controller;

import menu.domain.Coach;
import menu.domain.NotEatableFood;

import java.util.ArrayList;
import java.util.List;

import static menu.domain.Coach.makeCoach;
import static menu.view.InputView.*;
import static menu.view.OutputView.*;

public class MenuController {

    public void start() {
        try {
            List<Coach> coaches = init();

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
