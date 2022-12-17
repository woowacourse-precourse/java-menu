package menu.view;

import java.util.List;
import java.util.Map;

import static menu.constant.SystemConstant.*;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printServiceStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printResult(Map<String, List<String>> allRecommends) {
        System.out.println("메뉴 추천 결과입니다.");
        printDays();
        printCategories();
        allRecommends.keySet().forEach(coachName -> printEachCoachRecommends(coachName, allRecommends.get(coachName)));
    }

    private static void printDays() {
        System.out.println(OPEN_BRACKET + "구분"
                + PARTITION + "월요일"
                + PARTITION + "화요일"
                + PARTITION + "수요일"
                + PARTITION + "목요일"
                + PARTITION + "금요일" + CLOSE_BRACKET);
    }

    private static void printCategories() {
        System.out.println(OPEN_BRACKET + "카테고리"
                + PARTITION + "한식"
                + PARTITION + "한식"
                + PARTITION + "수요일"
                + PARTITION + "목요일"
                + PARTITION + "금요일" + CLOSE_BRACKET);
    }

    private static void printEachCoachRecommends(String coachName, List<String> menuNames) {
        System.out.print(OPEN_BRACKET + coachName);
        menuNames.forEach(menuName -> System.out.print(PARTITION + menuName));
        System.out.println(CLOSE_BRACKET);
    }
}
