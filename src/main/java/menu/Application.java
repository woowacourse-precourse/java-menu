package menu;

import container.SystemContainer;
import menu.controller.MenuRecommendController;

public class Application {
    public static void main(String[] args) {

        SystemContainer systemContainer = SystemContainer.getInstance();
        MenuRecommendController menuRecommendController = systemContainer.menuRecommendController();

        menuRecommendController.run();
    }
}
