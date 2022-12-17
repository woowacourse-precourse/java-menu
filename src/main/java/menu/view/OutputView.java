package menu.view;

import menu.utils.Message;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printStart() {
        System.out.println(Message.START);
    }
}
