package menu;

import menu.common.config.MenuRecommendConfig;
import menu.common.log.ConsoleLogger;
import menu.common.log.Logger;
import menu.controller.MenuRecommendController;
import menu.step.RecommendStartStep;
import menu.step.Step;

public class Application {
    public static void main(String[] args) {
        MenuRecommendConfig config = new MenuRecommendConfig();
        MenuRecommendController controller =
                new MenuRecommendController(config);
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
