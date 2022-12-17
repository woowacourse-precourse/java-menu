package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printStart();
    }
}
