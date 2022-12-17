package menu.controller;

import menu.model.CoachName;
import menu.model.Menu;
import menu.model.RecommendMachine;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class RecommendingController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void play() {
        outputView.printStartMessage();
        CoachName name = coachName();
        Menu menu = new Menu();
        checkDislikeFood(menu, name.getCoachNames());
        RecommendMachine recommendMachine = new RecommendMachine();
        recommend(menu, name, recommendMachine);
        outputView.printEndMessage();
    }

    private void checkDislikeFood(Menu menu, List<String> coachNames) {
        for (String name : coachNames) {
            List<String> dislikeFood = inputDislikeFoodBy(name);
            menu.dislike(name, dislikeFood);
        }
    }

    private CoachName coachName() {
        try {
            return new CoachName(inputCoachName());
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return coachName();
        }
    }

    private void recommend(Menu menu, CoachName coachName, RecommendMachine recommendMachine) {
        List<String> recommendingCategory = recommendMachine.recommendCategory();
        outputView.printResultMessage();
        outputView.printWeek();
        outputView.printRecommendCategory(recommendingCategory);
        for (String name : coachName.getCoachNames()) {
            List<String> recommendingMenu = recommendMachine.recommendMenu(menu, name, recommendingCategory);
            outputView.printRecommendMenu(recommendingMenu, name);
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
