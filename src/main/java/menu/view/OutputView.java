package menu.view;

public class OutputView {

    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }

    public void printError(String errorMessage) {
        final String ERROR_LOG_PREFIX = "[ERROR] ";
        System.out.println(ERROR_LOG_PREFIX + errorMessage);
    }
}
