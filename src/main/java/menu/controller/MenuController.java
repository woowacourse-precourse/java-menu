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
        askNoEat(coaches);
        menuSuggester.run();
    }

    private List<Coach> askCoach() {
        OutputView.askCoach();
        List<Coach> coaches = InputView.inputCoach();
        menuSuggester.setCoaches(coaches);
        return coaches;
    }

    private void askNoEat(List<Coach> coaches) {
        for (Coach coach : coaches) {
            OutputView.askNoEat(coach.getName());
            List<String> noEatFood = InputView.inputNoEat();
            coach.setNoEatFood(noEatFood);
            System.out.println(noEatFood);
        }

    }
}
