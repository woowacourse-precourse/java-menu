package menu;

import menu.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        // TODO: 프로그램 구현
    }
}
