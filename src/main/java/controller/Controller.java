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
        getCoachesInfo(coaches);
        MenuRecommender.getCoachRecommendFoods();
        outputView.printRecommendResult(MenuRecommender.getResult());
    }

    private void getCoachesInfo(List<String> coachNames) {
        for (String coach : coachNames) {
            String hateFoods = getEachCoachHateFoods(coach);
            MenuRecommender.creatorCoach(coach, hateFoods);
        }
    }

    private String getEachCoachHateFoods(String name) {
        return inputView.getHateFood(name);
    }
}
