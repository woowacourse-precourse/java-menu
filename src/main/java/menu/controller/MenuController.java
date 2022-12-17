package menu.controller;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.service.CoachFactory;
import menu.ui.InputView;
import menu.ui.OutputView;

public class MenuController {
    private final List<Category> categories;

    public MenuController(List<Category> categories) {
        this.categories = categories;
    }

    public void start() {
        OutputView.start();
        OutputView.enterCoach();
        List<Coach> coaches = getCoaches();
        getCantEatMenus(coaches);
    }

    private void getCantEatMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            findCantEatMenu(coach);
        }
    }

    private void findCantEatMenu(Coach coach) {
        OutputView.cantEatMenu(coach);
    }

    private static List<Coach> getCoaches() {
        try {
            String[] inputCoaches = InputView.coaches();
            return CoachFactory.makeCoaches(inputCoaches);
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return getCoaches();
        }
    }
}
