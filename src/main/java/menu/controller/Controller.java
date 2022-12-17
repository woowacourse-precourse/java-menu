package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void run() {
        OutputView.printMenuRecommendationStart();
        InputView.readCoachName();
    }
}
