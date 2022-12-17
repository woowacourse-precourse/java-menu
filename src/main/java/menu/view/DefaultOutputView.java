package menu.view;

public abstract class DefaultOutputView {

    private static final String PRINT_EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s";

    public void printExceptionMessage(String message) {
        System.out.println(String.format(PRINT_EXCEPTION_MESSAGE_FORMAT, message));
    }
}
