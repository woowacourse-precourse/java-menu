package menu.controller;

import menu.domain.Coach;
import menu.domain.FoodPeerCoaches;
import menu.domain.FoodRecommendMachine;
import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class FoodRecommendController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        outputView.printServiceIntroducingMessage();
        FoodRecommendMachine machine = new FoodRecommendMachine(readCoachInformation());
        machine.makeRecommend();
        outputView.printResultMessage(machine.getFoodRecommends());
    }

    private FoodPeerCoaches readCoachInformation() {
        FoodPeerCoaches foodPeerCoaches = inputView.readCoachPeers();
        for (Coach coach : foodPeerCoaches.getCoaches()) {
            enrollHateFoodOfCoach(coach);
        }
        return foodPeerCoaches;
    }

    private void enrollHateFoodOfCoach(Coach coach) {
        List<Menu> menus = inputView.readHateFoodOf(coach);
        coach.enrollHateFood(menus);
    }
}
