package menu.controller;

import java.util.List;
import menu.view.InputView;

public class MenuController {
    private final InputView inputView;

    public MenuController() {
        inputView = new InputView();
    }

    public void run() {
        List<String> coaches = inputView.readCoaches();
    }
}
