package menu.view;

public class OutputView {

    private static final String ERROR = "[ERROR] ";

    private OutputView() {
    }

    public static void printServiceStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }
}
