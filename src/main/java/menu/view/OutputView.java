package menu.view;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String END_MESSAGE_FORMAT = "메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n%s\n%s\n";

    public static final String END_MESSAGE = "추천을 완료했습니다.";
    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public static void printRecommendationResult(String resultForCategories, List<String> resultForCoaches) {
        String result = String.join("\n", resultForCoaches);
        System.out.printf(END_MESSAGE_FORMAT, resultForCategories, result);
        System.out.println();
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }



    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
