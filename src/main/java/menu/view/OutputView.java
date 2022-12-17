package menu.view;


public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RECOMMEND_RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
    private static final String MONDAY_TO_FRIDAY = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String END_MESSAGE = "추천을 완료했습니다.";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(String recommendCategory, String recommendMenu) {
        System.out.println(RECOMMEND_RESULT_MESSAGE);
        System.out.println(MONDAY_TO_FRIDAY);
        System.out.println(recommendCategory);
        System.out.println(recommendMenu);
    }

    public void printEnd() {
        System.out.print(END_MESSAGE);
    }
}
