package menu.controller;

import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private Coaches coaches;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.startMessage();
        coaches = getCoachesName();
    }

    public Coaches getCoachesName() {
        outputView.getCoachesName();
        return inputView.getCoachesName();
    }
}
