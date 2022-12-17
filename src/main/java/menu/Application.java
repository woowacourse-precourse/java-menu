package menu;

import menu.controller.MenuRecommendController;
import menu.util.SaveMenu;

public class Application {
    public static void main(String[] args) {
        MenuRecommendController menuRecommendController = new MenuRecommendController();
        SaveMenu saveMenu = new SaveMenu();
        saveMenu.init();    // 메뉴 추가
        menuRecommendController.startRecommend();
    }
}
