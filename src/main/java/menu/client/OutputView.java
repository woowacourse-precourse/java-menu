package menu.client;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    private OutputView() {
    }

    public static void printErrorMessage(String errorMessage) {
        println(ERROR_PREFIX + errorMessage);
    }

    public static void printStartMessage() {
        println(START_MESSAGE);
        println();
    }

    private static void println() {
        System.out.println();
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
