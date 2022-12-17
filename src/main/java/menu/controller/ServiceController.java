package menu.controller;

import menu.domain.Coach;
import menu.domain.Recommendation;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class ServiceController {

    InputView inputView;
    OutputView outputView;

    public ServiceController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printServiceStartMessage();
        List<String> coachNames = readCoachNames();
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            List<String> canNotEatMenus = readCanNotEatMenus(coachName);
            Coach coach = new Coach(coachName, canNotEatMenus);
            coaches.add(coach);
        }
        Recommendation recommendation = new Recommendation(coaches);
        recommendation.run();
        outputView.printServiceFinishMessage(recommendation.requestCategoryFormat(), recommendation.getCoaches());
    }

    private List<String> readCoachNames() {
        while (true) {
            try {
                return inputView.readCoachNames();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<String> readCanNotEatMenus(String coachName) {
        while (true) {
            try {
                return inputView.readCanNotEatMenus(coachName);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
