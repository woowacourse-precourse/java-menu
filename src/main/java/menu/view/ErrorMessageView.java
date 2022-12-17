package menu.view;

public class ErrorMessageView {

    public static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";

    public static void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
