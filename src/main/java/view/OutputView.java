package view;

public class OutputView {
    public static final String START_COMMENT = "점심 메뉴 추천을 시작합니다.";
    public static final String MENU_RESULT_START_COMMENT = "메뉴 추천 결과입니다.";
    public static final String MENU_RESULT_END_COMMENT = "추천을 완료했습니다.";

    public void printMenuRecommendStart() {
        System.out.println(START_COMMENT);
        System.out.println();
    }

    public void printRecommendResult(String menu) {
        System.out.println();
        System.out.println(MENU_RESULT_START_COMMENT);
        System.out.print(menu);
        System.out.println();
        System.out.println(MENU_RESULT_END_COMMENT);
    }
}
