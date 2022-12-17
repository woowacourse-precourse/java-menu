package menu.outputview;

public class ErrorHandlingOutputView {

    public static final String ERROR_FORMAT = "[ERROR] %s%n";

    public static void printErrorMessage(String message) {
        System.out.println();
        System.out.printf(ERROR_FORMAT, message);
    }
}
