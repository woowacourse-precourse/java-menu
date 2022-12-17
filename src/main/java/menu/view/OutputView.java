package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Weekday;
import menu.dto.RecommendDTO;

public class OutputView {
    private enum Message {
        INTRO("점심 메뉴 추천을 시작합니다."),
        RECOMMEND_RESULT("메뉴 추천 결과입니다."),
        OUTRO("추천을 완료했습니다.");

        private String explanation;

        Message(String explanation) {
            this.explanation = explanation;
        }
    }

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_FORMAT = "[ %s ]";
    private static final String SEPARATOR = " | ";

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
        System.out.println();
    }

    public static void printIntro() {
        System.out.println(Message.INTRO.explanation);
        System.out.println();
    }

    public static void printResult() {
        System.out.println(Message.RECOMMEND_RESULT.explanation);
        breakOneLineAfterPrint(makeWeekdayStatement());
        breakOneLineAfterPrint(makeCategoryStatement());
        for (Coach coach : RecommendDTO.getCoaches()) {
            breakOneLineAfterPrint(makeCoachStatement(coach));
        }
        System.out.println();
    }

    private static String makeWeekdayStatement() {
        StringBuilder str = new StringBuilder();
        str.append(Weekday.getClassName()).append(SEPARATOR);
        for (Weekday weekday : Weekday.values()) {
            str.append(weekday.getName()).append(SEPARATOR);
        }
        return str.substring(0, str.length() - 3);
    }

    private static String makeCategoryStatement() {
        StringBuilder str = new StringBuilder();
        str.append(Category.getClassName()).append(SEPARATOR);
        for (Weekday weekday : Weekday.getOrderedWeekdays()) {
            str.append(RecommendDTO.getCategoryNames(weekday)).append(SEPARATOR);
        }
        return str.substring(0, str.length() - 3);
    }

    private static String makeCoachStatement(Coach coach) {
        StringBuilder str = new StringBuilder();
        str.append(coach.getName());
        str.append(SEPARATOR);
        str.append(makeRecommendStatement(coach));
        return str.toString();
    }

    private static String makeRecommendStatement(Coach coach) {
        StringBuilder str = new StringBuilder();
        for (String foodName : RecommendDTO.getRecommendMenusOnCoach(coach)) {
            str.append(foodName);
            str.append(SEPARATOR);
        }
        return str.substring(0, str.length() - 3);
    }

    private static void breakOneLineAfterPrint(String statement) {
        System.out.printf(RESULT_FORMAT, statement);
        System.out.println();
    }

    public static void printOutro() {
        System.out.println(Message.OUTRO.explanation);
    }
}
