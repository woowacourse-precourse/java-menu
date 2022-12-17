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
        List<Coach> coaches = askCoach();
        for (Coach coach : coaches) {
            askNoEat(coach);
        }
        int[] suggestedCategory = menuSuggester.run();
        OutputView.showResult(suggestedCategory, coaches);
    }

    private List<Coach> askCoach() {
        List<Coach> coaches = null;
        do {
            try {
                OutputView.askCoach();
                coaches = InputView.inputCoach();
                menuSuggester.setCoaches(coaches);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (coaches == null);
        return coaches;
    }

    private void askNoEat(Coach coach) {
        List<String> noEatFood = null;
        do {
            try {
                OutputView.askNoEat(coach.getName());
                noEatFood = InputView.inputNoEat();
                coach.setNoEatFood(noEatFood);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (noEatFood == null);
    }

}
