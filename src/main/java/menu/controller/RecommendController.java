package menu.controller;

import menu.model.Coach;
import menu.model.Coaches;
import menu.model.Menus;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {

    private final RecommendService recommendService;

    public RecommendController() {
        this.recommendService = new RecommendService();
    }

    public void run() {
        OutputView.printStartMessage();

        final Coaches coaches = inputCoachName();

        for (Coach coach : coaches.getCoaches()) {
            final Menus menus = inputCannotEatFoods(coach);
            coach.addCannotEatFood(menus);
        }

    }

    private static Menus inputCannotEatFoods(final Coach coach) {
        try {
            final String cannotEatMenu = InputView.inputCannotEatMenu(coach.getName());
            return Menus.create(cannotEatMenu);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCannotEatFoods(coach);
        }
    }

    private static Coaches inputCoachName() {
        try {
            final String input = InputView.inputCoachName();
            return Coaches.create(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoachName();
        }
    }
}
