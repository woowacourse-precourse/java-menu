package menu.controller;

import menu.Coach;
import menu.FoodRecommendation;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    FoodRecommendation foodRecommendation;

    public void run() {
        OutputView.start();
        setCoachesAndInedibles();
        recommendFood();
        result();
    }

    private List<Coach> readCoachName() {
        OutputView.inputCoachName();
        return InputView.readCoachName().stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    private void setCoachesAndInedibles() {
        List<Coach> coaches = readCoachName();
        foodRecommendation = new FoodRecommendation(coaches);
        for (Coach coach : coaches) {
            OutputView.inputInedibleFood(coach);
            coach.addInedibleFoods(InputView.readInedibleFoods());
        }
    }

    private void recommendFood() {
        foodRecommendation.recommend();
    }

    private void result() {
        OutputView.result(foodRecommendation.getCoaches(), foodRecommendation.getCategoryByWeek());
    }
}
