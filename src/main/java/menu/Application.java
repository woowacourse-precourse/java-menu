package menu;

import menu.domain.Recommend;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new Recommend());
        controller.recommendMenu();
    }
}
