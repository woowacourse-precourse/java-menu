package menu.view;

import menu.domain.Coach;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final String START_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    private static final String BLANK = "";
    private static final String BAR = " | ";
    private static final String RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    private static final String END_RECOMMEND = "추천을 완료했습니다.";

    // TODO Enum 을 통해 형식으로 출력하도록 변경
    private static final String DIVISION = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY = "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]";
    private static final String COACH_RECOMMENDED_FOOD_FORMAT = "[ %s | %s ]";

    public static void printRecommendStart() {
        System.out.println(START_RECOMMEND);
    }

    public static void printRecommendResult(List<Coach> coaches) {
        System.out.println(RECOMMEND_RESULT);
        System.out.println(DIVISION);
        System.out.println(CATEGORY);
        printRecommends(coaches);
        System.out.println(END_RECOMMEND);
    }

    private static void printRecommends(List<Coach> coaches) {
        for (Coach coach : coaches) {
            String menus = coach.recommends().stream()
                    .map(it -> it.food().name()).
                    collect(joining(BAR));
            String message = format(COACH_RECOMMENDED_FOOD_FORMAT, coach.name(), menus);
            System.out.println(message);
        }
    }
}
