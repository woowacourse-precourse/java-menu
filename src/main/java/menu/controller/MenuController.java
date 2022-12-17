package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {

    public void start() {
        OutputView.printStartComment();

        List<String> names = inputCoachNames();
    }

    private List<String> inputCoachNames() {
        OutputView.printCoachNameComment();
        List<String> names = InputView.readNames();

        return names;
    }
}
