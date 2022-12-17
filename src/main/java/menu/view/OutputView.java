package menu.view;

public class OutputView {
    private final static String ERROR_HEADER = "[ERROR] ";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + errorMessage + "\n");
    }

    public static void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
}
