package menu.client;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private OutputView() {
    }

    public static void printErrorMessage(String errorMessage) {
        println(ERROR_PREFIX + errorMessage);
    }


    private static void println(String message) {
        System.out.println(message);
    }
}
