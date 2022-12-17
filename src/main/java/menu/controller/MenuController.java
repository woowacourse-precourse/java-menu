package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    
    public MenuController() {
        inputView = new InputView();
        this.outputView = new OutputView();
    }
    
    public void run() {
        outputView.printApplicationStartGuide();
        inputView.inputCoachNames(outputView);
    }
}
