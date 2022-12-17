package menu.application;

import menu.controller.MenuController;
import menu.domain.Coach;
import menu.handler.InputHandler;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuApplication {

    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final MenuController menuController;

    public MenuApplication() {
        this.inputHandler = new InputHandler(new InputView());
        this.outputView = new OutputView();
        this.menuController = new MenuController();
    }

    public void run() {
        outputView.printStart();
        Coach coach = inputHandler.readCoachName();
        inputHandler.readCoachCanNotEat(coach);

        menuController.recommendCategory();
        menuController.recommendForCoach(coach, menuController.getRecommendCategory());

        outputView.printResult(menuController.getRecommendCategoryWord(), coach.toString());
        outputView.printEnd();
    }
}
