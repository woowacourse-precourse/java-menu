package controller;

import exception.CoachException;
import exception.FoodException;
import menu.domain.Coach;
import menu.domain.MenuRecommender;
import repository.MenuForWeekRepository;
import view.InputView;
import view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    private final OutputView outputView;
    private final InputView inputView;

    public MenuController(OutputView outputView) {
        this.outputView = outputView;
        this.inputView = new InputView(outputView);
    }

    public void run() {
        outputView.printStartMessage();
        List<Coach> coaches = makeCoaches(inputView.readCoachNames());
        for (Coach coach : coaches) {
            List<String> foodNames = getHateFoodNames(inputView.readHateFood(coach.getName()), coach.getName());
            coach.addHateFoodList(foodNames);
        }
        MenuRecommender.addRecommendMenus(coaches);
        outputView.printMenuResult(MenuForWeekRepository.getMenuResult());
    }

    private List<String> getHateFoodNames(String hateFoodNames, String coachName) {
        try {
            if (!hateFoodNames.isEmpty()) {
                List<String> foodNames = splitNames(hateFoodNames);
                FoodException.validate(foodNames);
                return foodNames;
            }
            return Collections.emptyList();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return getHateFoodNames(inputView.readHateFood(coachName), coachName);
        }
    }

    private List<Coach> makeCoaches(String coachNames) {
        try {
            List<String> names = splitNames(coachNames);
            CoachException.validate(names);
            List<Coach> coaches = makeCoaches(names);
            MenuForWeekRepository.initializeCoaches(coaches);
            return coaches;
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return makeCoaches(inputView.readCoachNames());
        }
    }

    private List<Coach> makeCoaches(List<String> coachNames) {
        return coachNames.stream().map(name -> new Coach(name))
                .collect(Collectors.toList());
    }

    private List<String> splitNames(String names) {
        return List.of(names.split(","));
    }
}
