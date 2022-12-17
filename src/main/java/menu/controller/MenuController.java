package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

public class MenuController {
    private List<String> coachName;
    private Map<String, List<String>> coachDislikeFood;

    private InputView inputView;
    private OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private void setCoachName() {
        outputView.printInputCoachNameMessage();
        coachName = inputView.readCoachName();
    }

    private void setCoachDislikeFood() {
        coachDislikeFood = inputView.readCoachDislikeFood(coachName);
    }
}
