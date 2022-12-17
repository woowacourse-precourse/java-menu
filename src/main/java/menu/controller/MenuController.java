package menu.controller;

import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    public void run() {
        OutputView.printServiceStartMessage();
        Coaches coaches = initCoaches();
    }

    private static Coaches initCoaches() {
        try {
            return new Coaches(InputView.inputCoachName());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return initCoaches();
        }
    }
}
