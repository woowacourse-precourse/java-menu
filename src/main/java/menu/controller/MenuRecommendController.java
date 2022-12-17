package menu.controller;

import java.util.List;
import menu.service.CoachService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {

    public void run() {
        OutputView.printRun();
        addCoach(InputView.readCoach());
    }

    public void addCoach(List<String> coachNames) {
        CoachService.addCoaches(coachNames);
    }

}
