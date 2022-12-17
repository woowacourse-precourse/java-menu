package menu.controller;

import java.util.List;
import menu.domain.CategoryHistory;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private InputView inputView;
    private OutputView outputView;
    private CategoryHistory categoryHistory;
    private List<Coach> coaches;

    public void startMenuRecommendService() {
        outputView.printServiceStartNotice();
        readCoachNames();
    }

    private void readCoachNames() {
        outputView.printCoachNameInputNotice();
        String coachNameInput = inputView.readCoachNames();

        String[] coachNames = coachNameInput.split(",");
        for (String name : coachNames) {
            coaches.add(new Coach(name));
        }
    }
}
