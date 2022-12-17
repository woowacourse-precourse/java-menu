package menu.view;

import menu.domain.Category;

import java.util.List;

public class OutputView {

    public static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    public static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String CANT_EAT_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    public static final String RECOMMENDATION_RESULT_MENU = "메뉴 추천 결과입니다.";
    public static final String RESULT_CLASSIFICATION = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    public static final String RESULT_CATEGORY = "[ 카테고리 | ";


    public void printFeatures() {
        System.out.println(START_MESSAGE);
        System.out.println();
        System.out.println(INPUT_COACH_NAME);
    }

    public void printCantEatMenu(String coachName) {
        System.out.println(String.format(CANT_EAT_MENU, coachName));
    }

    public void printResult() {
        System.out.println(RECOMMENDATION_RESULT_MENU);
        System.out.println(RESULT_CLASSIFICATION);
    }

    public void printRandomCategory(List<Category> categories) {
        StringBuilder result = new StringBuilder(RESULT_CATEGORY);
        for (Category category : categories) {
            result.append(category.getCategoryName())
                    .append(" |");
        }
        result.append(" ]");
        System.out.println(result);
    }
}
