package menu;

import menu.controller.RecommendSystemController;
import menu.domain.RecommendSystem;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RecommendSystem recommendSystem = new RecommendSystem();
        RecommendSystemController recommendSystemController = new RecommendSystemController(recommendSystem);
        recommendSystemController.run();
    }
}
