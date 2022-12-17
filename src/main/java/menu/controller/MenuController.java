package menu.controller;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menus;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    public void run() {
        OutputView.printServiceStartMessage();
        Coaches coaches = initCoaches();
        addCanNotEatMenus(coaches);
    }

    private static Coaches initCoaches() {
        try {
            return new Coaches(InputView.inputCoachName());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return initCoaches();
        }
    }

    private static void addCanNotEatMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            try {
                coach.addCanNotEatMenus(new Menus(InputView.inputCanNotEatMenus(coach.getName())));
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
                addCanNotEatMenus(coaches);
            }
        }
    }
}
