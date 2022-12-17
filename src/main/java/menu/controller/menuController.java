package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class menuController {

    public static OutputView outputView = new OutputView();
    public static InputView inputView = new InputView();

    public static void start(){
        outputView.printStart();
        List<String> coaches = inputView.inputCoach();
    }


}
