package menu.view;

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
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(menuResult);
    }

    private static void printCategory(MenuResult menuResult) {
        List<String> categoryNames = menuResult.getCategory()
                .stream()
                .map(category -> category.getName())
                .collect(Collectors.toList());
        System.out.println(String.join(" | ", categoryNames));
    }

}
