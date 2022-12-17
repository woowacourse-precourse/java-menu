package menu;

import menu.controller.MealRecommendationController;

public class Application {
    public static void main(String[] args) {
        MealRecommendationController mealController = new MealRecommendationController();
        mealController.run();
    }
}
