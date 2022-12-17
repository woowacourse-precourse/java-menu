package menu.controller;

import menu.view.OutputView;

public class MainController {
    private final MenuController menuController;
    private final CoachController coachController;
    private final MenuRecommendController menuRecommendController;


    public MainController() {
        this.menuController = new MenuController();
        this.coachController = new CoachController();
        this.menuRecommendController = new MenuRecommendController();
    }

    public void run() {
        OutputView.printMenuProgramStartMessage();
        menuController.initMenu();
        coachController.addCoaches();
        menuRecommendController.recommendWeekMenu();
    }
}
