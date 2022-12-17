package menu;

import menu.controller.RecommendationController;

public class Application {
    public static void main(String[] args) {
        RecommendationController recommendationController = new RecommendationController();
        recommendationController.startRecommendation();
    }
}
