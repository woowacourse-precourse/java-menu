package controller;

import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        outputView.printMenuRecommendStart();
        String coachNames = inputView.getCoachNames();
    }
}
