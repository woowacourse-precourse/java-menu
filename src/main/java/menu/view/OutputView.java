package menu.view;

import menu.domain.Coach;

import java.util.List;

public class OutputView {
    private final String START_MENTION = "점심 메뉴 추천을 시작합니다.";
    private final String COACH_NAME_REQUEST_MENTION = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String RESULT_MENTION = "메뉴 추천 결과입니다.";
    private final String END_MENTION = "추천을 완료했습니다.";
    private final String WEEK = "구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일";
    private final String SEPARATOR = " | ";

    public void printStart() {
        System.out.println(START_MENTION + "\n");
    }

    public void printCoachNameRequest() {
        System.out.println(COACH_NAME_REQUEST_MENTION);
    }

    public void printResult() {
        System.out.println(RESULT_MENTION);
    }

    public void printEnd() {
        System.out.println(END_MENTION + "\n");
    }

    public void printError(IllegalArgumentException exception) {
        System.out.println("\n" + exception.getMessage());
    }

    public void printWeek() {
        System.out.print("[ ");
        System.out.print(WEEK);
        System.out.println(" ]");
    }

    public void printCategory(List<String> categories) {
        System.out.print("[ 카테고리" + SEPARATOR);
        System.out.print(String.join(SEPARATOR, categories));
        System.out.println(" ]");
    }

    public void printCoach(List<Coach> coaches) {
        for (Coach coach : coaches) {
            System.out.print("[ " + coach.toString() + SEPARATOR);
            System.out.print(String.join(SEPARATOR, coach.getRecommendedFoods()));
            System.out.println(" ]");
        }

        System.out.println();
    }
}
