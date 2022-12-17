package menu;

import menu.input.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }

    private static void run() {
        String[] coaches = InputView.readCoachNames();
    }
}
