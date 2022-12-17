package menu;

import menu.controller.CoachController;
import menu.model.domain.Coach;
import menu.model.service.CoachService;
import menu.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            CoachController coachController = new CoachController(new CoachService());
            OutputView.printStart();
            List<String> coachesName = coachController.getCoachesName();

            List<Coach> coaches = coachController.getCoachHateMenus(coachesName);
            coachController.showRecommendMenu(coaches);

            OutputView.printEnd();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}