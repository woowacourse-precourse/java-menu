package menu;

import menu.controller.InitController;
import menu.controller.MealRecommendationController;

public class Application {
    public static void main(String[] args) {
        InitController initController = new InitController();
        MealRecommendationController mealController = new MealRecommendationController();
        initController.run();
        mealController.run();
    }
}
