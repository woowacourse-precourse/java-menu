package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

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
        List<String> coachNames = inputController.readValidCoachNames();
        System.out.println(inputController.readValidHateMenusByCoach(coachNames));
    }
}