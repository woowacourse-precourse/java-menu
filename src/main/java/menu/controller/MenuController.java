package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final OutputView outputView;
    private final InputView inputView;

    public MenuController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        outputView.outputStartNotice();
        inputView.inputCoachNames();
    }
}
