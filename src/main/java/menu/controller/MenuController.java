package menu.controller;

import java.util.List;
import menu.CategoryRandomNumberGenerator;
import menu.domain.Coach;
import menu.domain.RecommendResult;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CategoryRandomNumberGenerator categoryRandomNumberGenerator;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.categoryRandomNumberGenerator = new CategoryRandomNumberGenerator();
    }

    public void run() {
        outputView.printServiceStart();
        List<Coach> coaches = getInputs();
        RecommendResult recommendResult = new RecommendResult(coaches, categoryRandomNumberGenerator);
        recommendResult.makeRecommendResult();
        outputView.printRecommendResult(coaches, recommendResult.getCategories());
    }

    public List<Coach> getInputs() {
        List<String> coachNames = getCoachName();
        List<Coach> coaches = getCoachCannotEatMenus(coachNames);
        return coaches;
    }

    public List<String> getCoachName() {
        try {
            return inputView.getCoachName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoachName();
        }
    }

    public List<Coach> getCoachCannotEatMenus(List<String> coachNames) {
        try {
            return inputView.getCoachCannotEatMenus(coachNames);
        }  catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoachCannotEatMenus(coachNames);
        }
    }
}
