package menu.view;

import menu.Coach;

public class OutputView {

    public static void print(PrintMessages printMessage) {
        System.out.println(printMessage.getMessage());
    }

    public static void start() {
        print(PrintMessages.SERVICE_START);
    }

    public static void insertCoaches() {
        print(PrintMessages.INSERT_COACHES);
    }

    public static void insertHateMenuBy(Coach coach) {
        System.out.println(PrintMessages.hateMenuBy(coach));
    }
}
