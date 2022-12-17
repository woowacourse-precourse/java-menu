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
            init();

        } catch (IllegalArgumentException error) {
            printErrorMessage(error.getMessage());
        }
    }

    private void init() {
        printStartMessage();
        createCoaches();
    }

    private List<Coach> createCoaches() {
        List<Coach> coaches = new ArrayList<>();
        List<String> coachNames = getCoachNames();
        for (String name : coachNames) {
            coaches.add(createCoach(name));
        }
        return coaches;
    }

    private Coach createCoach(String name) {
        NotEatableFood notEatableFood = getNotEatableFood(name);
        return makeCoach(name, notEatableFood);
    }

    private List<String> getCoachNames() {
        List<String> coachNames = getCoachName();
        printCoachNames(coachNames);
        return coachNames;
    }
}
