package menu;

import menu.domain.MenuRecommendManager;

public class Application {
    public static void main(String[] args) {
        MenuRecommendManager menuRecommendManager = new MenuRecommendManager();
        menuRecommendManager.executeRecommendMenu();
    }
}
