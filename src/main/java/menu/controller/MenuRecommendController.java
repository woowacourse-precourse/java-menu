package menu.controller;

import menu.model.Coach;
import menu.model.Coaches;
import menu.model.HateMenu;
import menu.service.MenuRecommendService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommendController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    MenuRecommendService menuRecommendService = new MenuRecommendService();

    public void performingProgram() {
        initInformation();
        menuRecommendService.selectWeekCategory();
    }

    private void initInformation() {
        Coaches coaches = initCoaches();
        coaches = initHateMenuPerCoaches(coaches);
        coaches = setRandomMenuPerCoach(coaches);
    }

    private Coaches initCoaches() {
        try {
            return addPerCoach();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return addPerCoach();
        }
    }

    private Coaches addPerCoach() {
        Coaches coaches = new Coaches();
        for (String name : enterCoachesName()) {
            coaches.addCoach(new Coach(name));
        }

        return coaches;
    }

    private List<String> enterCoachesName() {
        try {
            return inputView.readCoachesName();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enterCoachesName();
        }
    }

    private Coaches initHateMenuPerCoaches(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            coach.addHateMenus(initHateMenu(coach));
        }

        return coaches;
    }

    private HateMenu initHateMenu(Coach coach) {
        try {
            return new HateMenu(enterCoachHateMenu(coach.getName()));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return initHateMenu(coach);
        }
    }

    private List<String> enterCoachHateMenu(String coachName) {
        try {
            return inputView.readCoachHateMenu(coachName);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enterCoachHateMenu(coachName);
        }
    }

    private Coaches setRandomMenuPerCoach(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            coach.addSelectMenu(menuRecommendService.selectWeekMenu(coach));
        }

        return coaches;
    }
}
