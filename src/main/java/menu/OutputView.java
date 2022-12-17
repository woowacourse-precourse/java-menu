package menu;

import java.util.List;

public class OutputView {
    private final String START_MENTION = "점심 메뉴 추천을 시작합니다.";
    private final String COACH_NAME_REQUEST_MENTION = "코치의 이름을 입력해주세요. (, 로 구분)";
    private final String RESULT_MENTION = "메뉴 추천 결과입니다.";
    private final String END_MENTION = "추천을 완료했습니다.";
    private final String WEEK = "구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일";

    public void printStart() {
        System.out.println(START_MENTION);
    }

    public void printCoachNameRequest() {
        System.out.println(COACH_NAME_REQUEST_MENTION);
    }

    public void printResult() {
        System.out.println(RESULT_MENTION);
    }

    public void printEnd() {
        System.out.println(END_MENTION);
    }

    public void printError(IllegalArgumentException exception) {
        System.out.print(exception.getMessage());
    }

    public void printWeek() {
        System.out.print("[ ");
        System.out.print(WEEK);
        System.out.println(" ]");
    }

    public void printCategory(List<String> categories) {
        System.out.print("[ 카테고리 ");
        System.out.print(String.join(" | ", categories));
        System.out.println(" ]");
    }

    public void printCoach(CoachRepository coachRepository) {
        List<Coach> coaches = coachRepository.getCoaches();

        for (Coach coach : coaches) {
            System.out.print("[ " + coach.getName() + " | ");
            System.out.print(String.join(" | ", coach.getRecommendedFoods()));
            System.out.println(" ]");
        }
    }
}
