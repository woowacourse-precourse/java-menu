package menu.controller;

import menu.model.Coaches;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {

    private final RecommendService recommendService;

    public RecommendController() {
        this.recommendService = new RecommendService();
    }

    public void run() {
        OutputView.printStartMessage();

        final Coaches coaches = inputCoachName();
    }

    private static Coaches inputCoachName() {
        try {
            final String input = InputView.inputCoachName();
            return Coaches.create(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoachName();
        }
    }
}
