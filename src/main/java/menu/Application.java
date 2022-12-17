package menu;

import menu.controller.RecommendationController;

public class Application {
    public static void main(String[] args) {
        RecommendationController controller = new RecommendationController();
        controller.start();
    }
}
