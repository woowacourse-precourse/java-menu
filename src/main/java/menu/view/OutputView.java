package menu.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String MENU_PROGRAM_START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private static final String MENU_PROGRAM_END_MESSAGE = "\n추천을 완료했습니다.";
    private static final String RECOMMEND_MENU_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String DAYS_INFO = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_PREFIX = "[ 카테고리 | ";
    private static final String CATEGORY_DELIMITER = " | ";
    private static final String CATEGORY_SUFFIX = " ]";
    private static final String MENU_DELIMITER = " | ";
    private static final String MENU_PREFIX = "[ ";
    private static final String MENU_SUFFIX = " ]";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printMenuProgramStartMessage() {
        System.out.println(MENU_PROGRAM_START_MESSAGE);
    }

    public static void printMenuProgramEndMessage() {
        System.out.println(MENU_PROGRAM_END_MESSAGE);
    }

    public static void printWeekRecommendMenu(List<String> categories, Map<String, List<String>> menus) {
        System.out.println(RECOMMEND_MENU_MESSAGE);
        System.out.println(DAYS_INFO);
        printCategories(categories);
        printMenuNamesOfCoaches(menus);
    }

    private static void printCategories(List<String> categories) {
        System.out.print(CATEGORY_PREFIX);
        System.out.print(String.join(CATEGORY_DELIMITER, categories));
        System.out.println(CATEGORY_SUFFIX);
    }

    private static void printMenuNamesOfCoaches(Map<String, List<String>> menus) {
        menus.entrySet().forEach(entry -> {
            printMenuNamesOfCoach(entry.getKey(), entry.getValue());
        });
    }

    private static void printMenuNamesOfCoach(String coachName, List<String> menuNames) {
        System.out.println(
                MENU_PREFIX + coachName + MENU_DELIMITER + String.join(MENU_DELIMITER, menuNames) + MENU_SUFFIX);
    }
}
