package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachMenus;

public class Output {

    private static final String RESULT_MESSAGE = "\n추천을 완료했습니다.";
    private static final String START_MENU_SELECTION = "점심 메뉴 추천을 시작합니다.";
    private static final String SELECTION_MENUS_RESULT = "메뉴 추천 결과입니다.";
    private static final String WEEKDAY_RESULT = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_NAME = "카테고리 | ";
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String SEPARATOR = " | ";

    public static void printStartMenuSelection() {
        System.out.println(START_MENU_SELECTION);
    }

    public static void printMenusResult(List<Category> categories) {
        System.out.println(SELECTION_MENUS_RESULT);
        printWeekDay();
        printCategories(categories);
    }

    private static void printWeekDay() {
        System.out.println(WEEKDAY_RESULT);
    }

    private static void printCategories(List<Category> categories) {
        System.out.println(
                PREFIX + CATEGORY_NAME + categories.stream()
                        .map(category -> category.getName())
                        .collect(Collectors.joining(SEPARATOR)) + SUFFIX);
    }

    public static void printMenuResult(Coach coach, CoachMenus coachMenus) {
        System.out.println(PREFIX + coach + SEPARATOR + coachMenus + SUFFIX);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

}
