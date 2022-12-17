package menu.util;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String ERROR = "[ERROR] ";
    private static final String CATEGORY = "카테고리";
    private static final String OPEN = "[ ";
    private static final String CLOSE = " ]";
    private static final String DIVISION = " | ";
    private static final List<String> WEEK = List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일");

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }

    public static void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printWeek() {
        System.out.println("메뉴 추천 결과입니다.");

        System.out.println(OPEN + String.join(DIVISION, WEEK) + CLOSE);
    }

    public static void printCategories(List<String> categories) {
        List<String> result = new ArrayList<>();
        result.add(CATEGORY);
        result.addAll(categories);
        System.out.println(OPEN + String.join(DIVISION, result) + CLOSE);
    }

    public static void printRecommend(String name, List<String> menus) {
        List<String> result = new ArrayList<>();
        result.add(name);
        result.addAll(menus);
        System.out.println(OPEN + String.join(DIVISION, result) + CLOSE);
    }

    public static void printEnd() {
        System.out.println("추천을 완료했습니다.");
    }
}
