package menu.controller;

import menu.model.Coach;
import menu.model.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommendController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void performingProgram() {

    }

    private void initInformation() {

    }

    private Coaches initCoaches() {
        try {
            return addPerCoach();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return addPerCoach();
        }
    }

    private Coaches addPerCoach() {
        Coaches coaches = new Coaches();
        for (String name : enterCoachesName()) {
            coaches.addCoach(new Coach(name));
        }

        return coaches;
    }

    private List<String> enterCoachesName() {
        try {
            return inputView.readCoachesName();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enterCoachesName();
        }
    }
}
