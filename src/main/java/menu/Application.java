package menu;

import static menu.configure.MenuConfigure.configure;
import menu.controller.MenuRecommendationController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuRecommendationController controller = new MenuRecommendationController();
        controller.run();
    }
}
