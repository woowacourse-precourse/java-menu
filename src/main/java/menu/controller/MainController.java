package menu.controller;

import menu.module.RepeatModule;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController extends RepeatModule {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public MainController() {
        outputView.printStart();
    }

    public void start() {

    }
}
