package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    public void execute(){
        OutputView.printServiceStartMessage();
        OutputView.printGetCoachNamesMessage();
        String[] coachNames = InputView.readCoachNames();

    }
}
