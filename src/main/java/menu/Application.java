package menu;

import menu.controller.MenuRecommendationController;
import menu.recommendation.MenuGenerator;

/**
 * 애플리케이션의 시작점이다.
 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuRecommendationController controller = new MenuRecommendationController();
        controller.run();
    }
}
