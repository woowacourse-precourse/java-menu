package menu.view;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {

    public static final String PREFIX = "[ ";
    public static final String SUFFIX = " ]";
    public static final String DELIMITER = " | ";
    public static final String DAY_TITLE = "구분";
    public static final String CATEGORY_TITLE = "카테고리";

    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public void printError(String errorMessage) {
        final String ERROR_LOG_PREFIX = "[ERROR] ";
        System.out.println(ERROR_LOG_PREFIX + errorMessage);
    }

    public void printResult(List<String> days, List<String> categories,
        Map<String, List<String>> coachFoods) {
        System.out.println("메뉴 추천 결과입니다.");
        printDays(days);
        printCategories(categories);
        printCoachAndFoods(coachFoods);
        System.out.println("\n추천을 완료했습니다.");
    }

    private void printDays(List<String> days) {
        addTitle(days, DAY_TITLE);
        printMessage(String.join(DELIMITER, days));
    }

    private void addTitle(List<String> list, String title) {
        list.add(0, title);
    }

    private void printMessage(String message) {
        System.out.println(PREFIX + message + SUFFIX);
    }

    private void printCategories(List<String> categories) {
        addTitle(categories, CATEGORY_TITLE);
        printMessage(String.join(DELIMITER, categories));
    }

    private void printCoachAndFoods(Map<String, List<String>> coachFoods) {
        Set<String> coaches = coachFoods.keySet();
        for (String coach : coaches) {
            List<String> eatFoods = coachFoods.get(coach);
            addTitle(eatFoods, coach);
            printMessage(String.join(DELIMITER, eatFoods));
        }
    }

}
