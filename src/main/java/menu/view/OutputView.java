package menu.view;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    private static final String END_MESSAGE = "추천을 완료했습니다.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(RECOMMEND_RESULT);
        // ToDo: 추천 결과
        System.out.println();
        System.out.println(END_MESSAGE);
    }
}
