package menu;

import menu.common.ConsoleLogger;
import menu.common.Logger;
import menu.controller.MenuRecommendController;
import menu.service.MenuRecommend;
import menu.service.SelectCategory;
import menu.step.RecommendStartStep;
import menu.step.Step;
import menu.usecase.MenuRecommendUseCase;
import menu.usecase.SelectCategoryUseCase;

public class Application {
    public static void main(String[] args) {
        MenuRecommendUseCase menuRecommend = new MenuRecommend();
        SelectCategoryUseCase selectCategoryUseCase = new SelectCategory();
        MenuRecommendController controller =
                new MenuRecommendController(menuRecommend, selectCategoryUseCase);
        Logger consoleLogger = new ConsoleLogger();
        Step step = new RecommendStartStep(controller, consoleLogger);

        run(step);
    }

    private static void run(Step step) {
        while (step.executable()) {
            step = step.execute();
        }
    }
}
