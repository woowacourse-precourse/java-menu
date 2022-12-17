package menu.controller;

import menu.view.OutputView;

public class MenuController {
    private final OutputView outputView;
    
    public MenuController() {
        this.outputView = new OutputView();
    }
    
    public void run() {
        outputView.printApplicationStartGuide();
    }
}
