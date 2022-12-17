package menu.view;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println(String.format(Message.ERROR.getMessage(), message));
    }
}
