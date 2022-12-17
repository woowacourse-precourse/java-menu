package menu.view;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printStart() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
