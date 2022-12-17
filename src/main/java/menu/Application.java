package menu;

import menu.controller.MenuRecommendController;

public class Application {
    public static void main(String[] args) {
        MenuRecommendController menuRecommendController = new MenuRecommendController();
        menuRecommendController.run();
    }
}
