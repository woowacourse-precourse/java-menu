package menu;

import menu.controller.MenuRecommendController;
import menu.domain.Menu;

public class Application {
    public static void main(String[] args) {
        MenuRecommendController menuRecommendController = new MenuRecommendController();
        menuRecommendController.run();

    }
}
