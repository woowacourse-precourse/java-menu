package menu.controller;

import menu.view.OutputView;

public class MenuSuggestionController {

    private final OutputView outputView;

    public MenuSuggestionController() {
        outputView = new OutputView();
    }

    public void startSuggestion() {
        outputView.printProgramStartInfo();
    }
}
