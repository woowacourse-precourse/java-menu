package menu;

import menu.controller.RecommenderController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RecommenderController recommenderController = new RecommenderController();
        recommenderController.run();
    }
}
