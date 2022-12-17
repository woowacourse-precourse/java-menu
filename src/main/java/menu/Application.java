package menu;

import controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuController controller = new MenuController();
        start(controller);
    }

    private static void start(MenuController controller) {
        try {
            controller.startRecommend();
        } catch (Exception e) {
            System.out.println("[ERROR] 알 수 없는 에러가 발생하였습니다.");
        }
    }
}
