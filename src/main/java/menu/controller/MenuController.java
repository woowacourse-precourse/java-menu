package menu.controller;

import menu.domain.*;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final CategoryGenerator categoryGenerator = new RandomCategoryGenerator();

    public void run() {
        OutputView.printServiceStartMessage();
        Coaches coaches = initCoaches();
        addCanNotEatMenus(coaches);
        RecommendService recommendService = new RecommendService(coaches);
        recommendService.recommend(categoryGenerator);

    }

    private static Coaches initCoaches() {
        try {
            return new Coaches(InputView.inputCoachName());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return initCoaches();
        }
    }

    private static void addCanNotEatMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            try {
                coach.addCanNotEatMenus(new Menus(InputView.inputCanNotEatMenus(coach.getName())));
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
                addCanNotEatMenus(coaches);
            }
        }
    }
}
