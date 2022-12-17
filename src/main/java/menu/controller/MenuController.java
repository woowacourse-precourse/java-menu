package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<Coach> coaches = getInputs();
    }

    public List<Coach> getInputs() {
        List<String> coachNames = getCoachName();
        List<Coach> coaches = getCoachCannotEatMenus(coachNames);
        return coaches;
    }

    public List<String> getCoachName() {
        try {
            return inputView.getCoachName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoachName();
        }
    }

    public List<Coach> getCoachCannotEatMenus(List<String> coachNames) {
        try {
            return inputView.getCoachCannotEatMenus(coachNames);
        }  catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoachCannotEatMenus(coachNames);
        }
    }
}
