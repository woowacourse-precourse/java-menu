package menu.controller;

import menu.domain.coach.Coach;
import menu.domain.factory.CoachCreator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    
    public MenuController() {
        inputView = new InputView();
        this.outputView = new OutputView();
    }
    
    public void run() {
        outputView.printApplicationStartGuide();
        List<Coach> coaches = inputView.repeatInput(() -> CoachCreator.from(inputView.inputCoachNames(outputView)), outputView);
        System.out.println(coaches);
    }
}
