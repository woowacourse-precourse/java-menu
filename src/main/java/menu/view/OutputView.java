package menu.view;

import menu.domain.Coach;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String INPUT_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_COACH_HATE_MENU_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String DAY_DIVISION_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_MESSAGE = "[ 카테고리 | %s | %s | %s | %s | %s ]";
    private static final String RECOMMENDED_MENU_MESSAGE = "[ %s | %s | %s | %s | %s | %s ]";


    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printInputCoachName() {
        System.out.println(INPUT_COACH_NAME_MESSAGE);
    }

    public void printInputCoachHateMenu(String coach) {
        System.out.println(coach + INPUT_COACH_HATE_MENU_MESSAGE);
    }

    public void printResultStartMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printDivision() {
        System.out.println(DAY_DIVISION_MESSAGE);
    }

    public void printCategories(List<String> categories) {
        System.out.println(String.format(CATEGORY_MESSAGE,
                categories.get(0), categories.get(1), categories.get(2), categories.get(3), categories.get(4)));
    }

    public void printRecommendedMenu(Coach coach) {
        System.out.println(RECOMMENDED_MENU_MESSAGE);
    }
}
