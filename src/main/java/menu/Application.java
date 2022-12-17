package menu;

import menu.controller.MenuController;
import menu.domain.Day;
import menu.domain.MenuRecommendationResult;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuController();
        menuController.run();

//        MenuRecommendationResult menuRecommendationResult = new MenuRecommendationResult();
//        for (Day day : Day.values()) {
//            menuRecommendationResult.selectDayCategory(day);
//        }
//        System.out.println(menuRecommendationResult.toString());
    }
}
