package menu.view;

public class OutputView {

    private void printBlankLine() {
        System.out.println();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
