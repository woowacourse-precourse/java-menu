package menu.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import menu.domain.Day;
import menu.domain.MenuRecommendation;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendationController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuRecommendation menuRecommendation;

    public RecommendationController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.menuRecommendation = new MenuRecommendation();
    }

    public void start() {
        outputView.printStart();
        List<String> coaches = initializeCoachName();
        initializeDislikeFood(coaches);
        recommendFood();
        printResult();
    }

    private List<String> initializeCoachName() {
        while (true) {
            try {
                List<String> coaches = transferToList(inputView.readCoachName());
                menuRecommendation.initializeCoaches(coaches);
                return coaches;
            } catch (IllegalArgumentException coachInputException) {
                System.out.println(coachInputException.getMessage());
            }
        }
    }

    private void initializeDislikeFood(List<String> coaches) {
        coaches.forEach(this::readEachDislikeFood);
    }

    private void readEachDislikeFood(String coach) {
        while (true) {
            try {
                menuRecommendation.initializeDislikeFoods(coach, transferToList(inputView.readDislikeFoods(coach)));
                return;
            } catch (IllegalArgumentException dislikeFoodException) {
                System.out.println(dislikeFoodException.getMessage());
            }
        }
    }

    private void recommendFood() {
        menuRecommendation.recommendFood();
    }

    private List<String> transferToList(String input) {
        if (input.equals("")) {
            return Collections.emptyList();
        }
        return Arrays.asList(input.split(","));
    }

    private void printResult() {
        outputView.printResult(Day.getDays(), menuRecommendation.getRecommendedCategories());
        outputView.printRecommendation(menuRecommendation.getRecommendationResult());
    }
}
