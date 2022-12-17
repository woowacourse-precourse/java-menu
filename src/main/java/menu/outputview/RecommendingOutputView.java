package menu.outputview;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.vo.Day;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendingOutputView {

    public static final String RECOMMENDING_RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    public static final String RECOMMEND_COMPLETED_MESSAGE = "추천을 완료했습니다.";
    public static final String CLOSING_BRACKET = " ]";
    public static final String OPENING_BRACKET = "[ ";
    public static final String VALUE_SEPARATOR = " | ";
    public static final String DAYS_MESSAGE_PREFIX = "구분 | ";
    public static final String CATEGORIES_MESSAGE_PREFIX = "카테고리 | ";

    public static void printRecommendingResult(List<String> categoryNames, Map<Coach, List<Menu>> recommendedMenus) {
        printResultMessage();
        printRecommendedMenus(categoryNames, recommendedMenus);
        printResultCompletedMessage();
    }

    private static void printRecommendedMenus(List<String> categoryNames, Map<Coach, List<Menu>> recommendedMenus) {
        printDays();
        printCategories(categoryNames);
        for (Map.Entry<Coach, List<Menu>> coachAndMenus : recommendedMenus.entrySet()) {
            printRecommendedMenu(coachAndMenus);
        }
    }

    private static void printRecommendedMenu(Map.Entry<Coach, List<Menu>> coachAndMenus) {
        printOpening();
        System.out.printf("%s | ", coachAndMenus.getKey().getName());
        printMenuNames(coachAndMenus);
        printClosing();
    }

    private static void printResultCompletedMessage() {
        System.out.println();
        System.out.println(RECOMMEND_COMPLETED_MESSAGE);
    }

    private static void printResultMessage() {
        System.out.println();
        System.out.println(RECOMMENDING_RESULT_MESSAGE);
    }

    private static void printMenuNames(Map.Entry<Coach, List<Menu>> coachAndMenus) {
        List<String> menuNames = getMenuNames(coachAndMenus);
        Iterator<String> iterator = menuNames.iterator();
        printValues(iterator);
    }

    private static List<String> getMenuNames(Map.Entry<Coach, List<Menu>> coachAndMenus) {
        return coachAndMenus.getValue().stream().map(Menu::getName).collect(Collectors.toList());
    }

    private static void printCategories(List<String> categoryNames) {
        printOpening();
        System.out.print(CATEGORIES_MESSAGE_PREFIX);
        Iterator<String> iterator = categoryNames.iterator();
        printValues(iterator);
        printClosing();
    }

    private static void printDays() {
        printOpening();
        System.out.print(DAYS_MESSAGE_PREFIX);
        Iterator<String> iterator = Day.findAllNames().iterator();
        printValues(iterator);
        printClosing();
    }

    private static void printClosing() {
        System.out.println(CLOSING_BRACKET);
    }

    private static void printOpening() {
        System.out.print(OPENING_BRACKET);
    }

    private static void printValues(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(VALUE_SEPARATOR);
            }
        }
    }
}
