package menu;

import menu.controller.MenuController;
import menu.service.BanService;
import menu.service.CoachService;
import menu.service.ResultService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuController(new CoachService(), new BanService(), new ResultService());
        menuController.start();
        menuController.select();
    }
}
