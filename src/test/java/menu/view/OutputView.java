package menu.view;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String END_MESSAGE_FORMAT = "메뉴 추천 결과입니다.\n%s\n추천을 완료했습니다.";
    public static void printExceptionMessageForInvalidInput(String exceptionMessage) {
        System.out.println("[ERROR] " + exceptionMessage);
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printEndMessage(List<String> resultForCoaches) {
        String result = String.join("\n", resultForCoaches);
        System.out.printf(END_MESSAGE_FORMAT, result);
    }
}
