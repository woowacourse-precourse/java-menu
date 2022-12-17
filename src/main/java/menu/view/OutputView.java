package menu.view;

import static menu.constant.Constants.*;

public class OutputView {

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printRequestCoachNameMessage() {
        System.out.println(REQUEST_COACH_NAME_MESSAGE);
    }

    public static void printName(String name) {
        System.out.print(name);
    }

    public static void printCantEatingMessage() {
        System.out.println(REQUEST_CANT_EATING_MENU_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
        System.out.println(CATEGORY_DAY_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
