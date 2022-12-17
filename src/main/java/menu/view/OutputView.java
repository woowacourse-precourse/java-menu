package menu.view;

public class OutputView {
    private static final String START_RUN = "점심 메뉴 추천을 시작합니다.\n";
    private static final String ERROR = "[ERROR] ";

    public void printStartMessage() {
        System.out.println(START_RUN);
    }
    public void printError(String message) {
        System.out.println(ERROR + message);
    }
}
