package menu;

import menu.controller.MenuRecommenderController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuRecommenderController menuRecommenderController = new MenuRecommenderController();
        menuRecommenderController.run();
    }
}
