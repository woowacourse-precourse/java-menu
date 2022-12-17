package menu.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String MENU_PROGRAM_START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    public static final String MENU_PROGRAM_END_MESSAGE = "\n추천을 완료했습니다.";
    public static void printMenuProgramStartMessage(){
        System.out.println(MENU_PROGRAM_START_MESSAGE);
    }

    public static void printMenuProgramEndMessage(){
        System.out.println(MENU_PROGRAM_END_MESSAGE);
    }

    public static void printWeekRecommendMenu(List<String> categories, Map<String, List<String>> menus) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategories(categories);
        printMenuNamesOfCoaches(menus);
    }

    private static void printCategories(List<String> categories) {
        System.out.print("[ 카테고리 | ");
        System.out.print(String.join(" | ", categories));
        System.out.println(" ] ");
    }

    private static void printMenuNamesOfCoaches(Map<String, List<String>> menus) {
        menus.entrySet().forEach(entry -> {
            printMenuNamesOfCoach(entry.getKey(), entry.getValue());
        });
    }

    private static void printMenuNamesOfCoach(String coachName, List<String> menuNames) {
        System.out.println("[ " + coachName + " | " + String.join(" | ", menuNames) + " ]");
    }
}
