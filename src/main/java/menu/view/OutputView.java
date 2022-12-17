package menu.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    private static final String MENU_RESULT_START = "메뉴 추천 결과입니다.";
    private static final String MENU_RESULT_END = "추천을 완료했습니다.";

    public static void showResult(String[] coachNames, List<String> totalDay, List<String> recommendedCategories,
                                  Map<String, List<String>> recommendMenusByCoach) {
        System.out.println(MENU_RESULT_START);
        printFormattedResultLine("구분", totalDay);
        printFormattedResultLine("카테고리", recommendedCategories);
        for (String coachName : coachNames) {
            printFormattedResultLine(coachName, recommendMenusByCoach.get(coachName));
        }
        System.out.println();
        System.out.println(MENU_RESULT_END);
    }

    public static void printFormattedResultLine(String group, List<String> contents) {
        StringJoiner result = new StringJoiner(" | ", "[ ", " ]");
        result.add(group);
        contents.forEach((content) -> result.add(content));
        System.out.println(result);
    }
}
