package menu.controller;

import menu.model.MenuSuggester;
import menu.view.OutputView;

public class MenuController {
    private final MenuSuggester menuSuggester;

    public MenuController(MenuSuggester menuSuggester) {
        this.menuSuggester = menuSuggester;
    }

    public void run() {
        OutputView.start();
    }
}
