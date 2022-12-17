package menu.view;

public class OutputView {
    private final static String ERROR_HEADER = "[ERROR] ";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + errorMessage + "\n");
    }
}
