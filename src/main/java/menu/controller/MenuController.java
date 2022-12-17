package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private InputView inputView;
    private OutputView outputView;
    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        outputView.startProgram();
    }
}
