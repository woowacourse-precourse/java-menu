package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputController inputController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputController = new InputController(inputView, outputView);
    }

    public void runMain() {
        outputView.printStart();
        System.out.println(inputController.readValidCoachNames());
    }
}