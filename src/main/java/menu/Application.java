package menu;

import menu.controller.MenuRecommendApplication;

public class Application {
    public static void main(String[] args) {
        try {
            MenuRecommendApplication menuRecommendApplication = new MenuRecommendApplication();
            menuRecommendApplication.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
