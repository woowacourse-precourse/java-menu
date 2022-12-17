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

    public static void printRecommendingResult(List<String> categoryNames, Map<Coach, List<Menu>> recommendedMenus) {
        printResultMessage();

        printDays();
        printCategories(categoryNames);
        for (Map.Entry<Coach, List<Menu>> coachAndMenus : recommendedMenus.entrySet()) {
            printOpening();
            System.out.printf("%s | ", coachAndMenus.getKey().getName());
            printMenuNames(coachAndMenus);
            printClosing();
        }

        printResultCompletedMessage();
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
        System.out.print("카테고리 | ");
        Iterator<String> iterator = categoryNames.iterator();
        printValues(iterator);
        printClosing();
    }

    private static void printDays() {
        printOpening();
        System.out.print("구분 | ");
        Iterator<String> iterator = Day.findAllNames().iterator();
        printValues(iterator);
        printClosing();
    }

    private static void printClosing() {
        System.out.println(" ]");
    }

    private static void printOpening() {
        System.out.print("[ ");
    }

    private static void printValues(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(" | ");
            }
        }
    }
}
