package menu;

import menu.controller.MenuController;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.service.MenuService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuController(menuService());
        menuController.run();
    }

    private static MenuService menuService() {
        return new MenuService(menuRepository(), coachRepository());
    }

    private static MenuRepository menuRepository() {
        return new MenuRepository();
    }

    private static CoachRepository coachRepository() {
        return new CoachRepository();
    }
}
