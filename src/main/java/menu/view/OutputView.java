package menu.view;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ERROR = "[ERROR] ";

    private OutputView() {
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }

    public static void printServiceStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public static void printServiceResult(MenuResult menuResult) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(menuResult);
        printMenu(menuResult.getCoaches());
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private static void printCategory(MenuResult menuResult) {
        List<String> categoryNames = menuResult.getCategory()
                .stream()
                .map(category -> category.getName())
                .collect(Collectors.toList());
        System.out.println("[ 카테고리 |" + String.join(" | ", categoryNames) + " ]");
    }

    private static void printMenu(Coaches coaches) {
        List<Coach> coachList = coaches.getCoaches();
        for (Coach coach : coachList) {
            System.out.print("[ " + coach.getName() + " | ");
            System.out.println(String.join(" | ", coach.getAteMenus()) + " ]");
        }
    }
}
