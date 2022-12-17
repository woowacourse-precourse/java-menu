package controller;

import menu.MenuRecommender;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        outputView.printMenuRecommendStart();
        String coachNames = inputView.getCoachNames();
        List<String> coaches = MenuRecommender.splitter(coachNames);
        getCoachsHateFood(coaches);
    }

    private void getCoachsHateFood(List<String> coaches) {
        for (String coach : coaches) {
            getEachCoachHateFoods(coach);
        }
    }

    private void getEachCoachHateFoods(String name) {
        String hateFoods = inputView.getHateFood(name);
        System.out.println(hateFoods);
    }
}
