package menu;

import menu.controller.RecommendingController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RecommendingController recommendingController = new RecommendingController();
        recommendingController.play();
    }
}
