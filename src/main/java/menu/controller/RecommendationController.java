package menu.controller;

import java.util.Arrays;
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
        inputView.readCoachName();
    }

    private void initializeCoachName() {
        while (true) {
            try {
                menuRecommendation.initializeCoaches(Arrays.asList(inputView.readCoachName().split(",")));
                return;
            } catch (IllegalArgumentException coachInputException) {
                System.out.println(coachInputException.getMessage());
            }

        }

    }
}
