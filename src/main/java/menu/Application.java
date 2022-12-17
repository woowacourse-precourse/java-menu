package menu;

import menu.controller.RecommendController;

public class Application {
    public static void main(String[] args) {
        RecommendController controller = new RecommendController();
        controller.run();
    }
}
