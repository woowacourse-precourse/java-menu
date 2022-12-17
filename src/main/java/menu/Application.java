package menu;

import menu.domain.Recommend;

public class Application {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller(new Recommend());
            controller.recommendMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
