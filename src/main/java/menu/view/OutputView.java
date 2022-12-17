package menu.view;

public class OutputView {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static void printException(Exception e) {
        System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
    }
}
