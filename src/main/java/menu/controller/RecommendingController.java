package menu.controller;

import menu.model.CoachName;
import menu.model.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class RecommendingController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void play() {
        outputView.printStartMessage();
        List<String> coachNames = inputCoachName();
        CoachName coachName = new CoachName(coachNames);
        Menu menu = new Menu();
        checkFood(menu, coachName.getCoachNames());
    }

    private void checkFood(Menu menu, List<String> coachNames) {
        for (String name : coachNames) {
            List<String> dislikeFood = inputDislikeFoodBy(name);
            menu.dislike(name, dislikeFood);
        }
    }

    private List<String> inputCoachName() {
        try {
            return inputView.readCoachNames();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return inputCoachName();
        }
    }

    private List<String> inputDislikeFoodBy(String name) {
        try {
            return inputView.readDislikeMenu(name);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return inputDislikeFoodBy(name);
        }
    }
}
