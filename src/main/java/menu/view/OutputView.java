package menu.view;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private static final String END_MESSAGE = "추천을 완료했습니다.\n";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

}
