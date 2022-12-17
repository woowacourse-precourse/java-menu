package menu.controller;

import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Menu menu = new Menu();

    private void initCoaches() {
        while (true) {
            try {
                String coachNames = inputView.readCoachNames();
                menu.addCoachNames(coachNames);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private void initCoach(String coachName) {
        while (true) {
            try {
                String inedibleMenu = inputView.readInedibleMenu();
                menu.addCoach(coachName, inedibleMenu);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }
}
