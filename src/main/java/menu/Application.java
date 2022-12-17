package menu;

import menu.controller.MenuRecommendationController;
import menu.recommendation.MenuGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuRecommendationController controller = new MenuRecommendationController();
        controller.run();
    }
}
