package menu;

import menu.controller.FoodRecommendController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        FoodRecommendController foodRecommendController = new FoodRecommendController();
        foodRecommendController.run();
    }
}
