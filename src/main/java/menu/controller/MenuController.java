package menu.controller;

import menu.domain.Coach;
import menu.FoodRecommendation;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    private FoodRecommendation foodRecommendation;

    public void run() {
        start();
        List<Coach> coaches = setCoaches();
        selectCategory(coaches);
        recommendFood();
        result();
    }

    private void start() {
        OutputView.start();
        OutputView.newLine();
    }

    private List<Coach> readCoachName() {
        OutputView.inputCoachName();
        return InputView.readCoachName().stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    private List<Coach> setCoaches() {
        List<Coach> coaches = readCoachName();
        OutputView.newLine();
        for (Coach coach : coaches) {
            setInedible(coach);
        }

        return coaches;
    }

    private void selectCategory(List<Coach> coaches) {
        foodRecommendation = new FoodRecommendation(coaches);
        foodRecommendation.selectRandomCategory();
    }

    private void setInedible(Coach coach) {
        OutputView.inputInedibleFood(coach);
        coach.addInedibleFoods(InputView.readInedibleFoods());
        OutputView.newLine();
    }

    private void recommendFood() {
        foodRecommendation.recommend();
    }

    private void result() {
        OutputView.result(foodRecommendation.getCoaches(), foodRecommendation.getCategoryByWeek());
    }
}
