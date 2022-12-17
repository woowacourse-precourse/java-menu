package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuController {
    private List<String> coachName;
    private Map<String, List<String>> coachDislikeFood;

    private InputView inputView;
    private OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private void setCoachName() {
        outputView.printInputCoachNameMessage();
        coachName = inputView.readCoachName();
    }

    private void setCoachDislikeFood() {
        coachDislikeFood = inputView.readCoachDislikeFood(coachName);
    }

    public String pickTodayRandomCategory() {
        List<String> categories = List.of("일식", "한식", "중식", "아시안", "양식");
        String category = categories.get(Randoms.pickNumberInRange(0, 4));
        return category;
    }
}
