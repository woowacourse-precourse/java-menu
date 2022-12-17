package menu.controller;

import menu.model.Coach;
import menu.model.MenuSuggester;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {
    private final MenuSuggester menuSuggester;

    public MenuController(MenuSuggester menuSuggester) {
        this.menuSuggester = menuSuggester;
    }

    public void run() {
        OutputView.start();
        askCoach();
    }

    private void askCoach() {
        OutputView.askCoach();
        List<Coach> coaches = InputView.inputCoach();
    }
}
