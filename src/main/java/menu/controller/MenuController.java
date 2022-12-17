package menu.controller;

import java.util.List;
import menu.domain.Category;
import menu.ui.OutputView;

public class MenuController {
    private final List<Category> categories;

    public MenuController(List<Category> categories) {
        this.categories = categories;
    }

    public void start() {
        OutputView.start();
        OutputView.enterCoach();
    }
}
