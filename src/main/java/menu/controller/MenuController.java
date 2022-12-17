package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.cofig.InitMenu;
import menu.domain.Category;
import menu.domain.Coach;
import menu.service.CoachFactory;
import menu.service.MenuFactory;
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
        List<List<String>> cantEatMenus = getCantEatMenus(coaches);
    }

    private List<List<String>> getCantEatMenus(List<Coach> coaches) {
        List<List<String>> cantEatMenus = new ArrayList<>();
        for (Coach coach : coaches) {
            cantEatMenus.add(findCantEatMenu(coach));
        }
        return cantEatMenus;
    }

    private List<String> findCantEatMenu(Coach coach) {
        try {
            OutputView.cantEatMenu(coach);
            String[] inputMenus = InputView.cantEatMenus();
            return MenuFactory.makeCantEatMenus(inputMenus);
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return findCantEatMenu(coach);
        }
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
