package menu.view;

import menu.utills.constants.ResultFormat;

import java.util.List;

public class OutputView {
    private final static String ERROR_HEADER = "[ERROR] ";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + errorMessage + "\n");
    }

    public static void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printFinalMessage() {
        System.out.println("\n메뉴 추천 결과입니다.\n" +
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public static void printCategoryResult(String message) {
        System.out.println(ResultFormat.getCategoryMessage(message));
    }

    public static void printRecommendResult(List<String> recommendedMenus) {
        recommendedMenus.forEach(recommendedMenu -> {
            System.out.println(ResultFormat.getRecommendedMenuMessage(recommendedMenu));
        });
    }
}
