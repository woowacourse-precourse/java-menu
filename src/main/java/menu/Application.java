package menu;

import menu.common.ConsoleLogger;
import menu.common.Logger;
import menu.controller.MenuRecommendController;
import menu.service.MenuRecommend;
import menu.step.RecommendStartStep;
import menu.step.Step;
import menu.usecase.MenuRecommendUseCase;

public class Application {
    public static void main(String[] args) {
        MenuRecommendUseCase menuRecommend = new MenuRecommend();
        MenuRecommendController controller = new MenuRecommendController(menuRecommend);
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
