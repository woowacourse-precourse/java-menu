package menu.view;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String MENU_SERVICE_START = "점심 메뉴 추천을 시작합니다.";
    private static final String REQUEST_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String REQUEST_COACH_NOT_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT_RECOMMEND_MENU = "메뉴 추천 결과입니다.";
    private static final String WEEKEND_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String STATIC_CATEGORY = "카테고리 | ";
    private static final String leftBracket = "[ ";
    private static final String rightBracket = " ]";
    private static final String middleBracket = " | ";
    private static final String SERVICE_END_MESSAGE = "추천을 완료했습니다.";

    public void printServiceStart() {
        System.out.println(MENU_SERVICE_START);
    }

    public void printRequestCoachName() {
        System.out.println(REQUEST_COACH_NAME);
    }

    public void printRequestRefuseMenu(Coach coach) {
        System.out.println(coach.getName() + REQUEST_COACH_NOT_MENU);
    }

    public void printResult() {
        System.out.println(RESULT_RECOMMEND_MENU);
        System.out.println(WEEKEND_MESSAGE);
    }

    public void printCategoryResult(List<String> categories) {
        List<String> categoryNames = new ArrayList<>(categories);
        System.out.println(leftBracket + STATIC_CATEGORY +String.join(middleBracket,  categoryNames) + rightBracket);
    }

    public void printRecommendMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<String> result = new ArrayList<>();
            result.add(coach.getName());
            result.addAll(coach.getRecommendMenus());
            System.out.println(leftBracket + String.join(middleBracket, result) + rightBracket);
        }
    }

    public void printServiceExit() {
        System.out.println(SERVICE_END_MESSAGE);
    }
}
