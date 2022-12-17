package menu;

import menu.controller.MenuController;
import menu.domain.RecommendationMachine;
import menu.service.MenuService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new MenuController(new MenuService(new RecommendationMachine())).run();
    }
}
