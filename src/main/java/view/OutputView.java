package view;

import domain.Menu;

public final class OutputView {
    private static final String START_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_COACH_HATE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    private static final String MENU_RECOMMEND_RESULT = "메뉴 추천 결과입니다.";

    private OutputView() {}

    public static void printStartRecommend() {
        System.out.println(START_RECOMMEND);
    }

    public static void printInputCoachNames() {
        System.out.println(INPUT_COACH_NAME);
    }

    public static void printInputCoachHateMenu(Menu menu) {
        System.out.printf(INPUT_COACH_HATE_MENU, menu);
    }


}
