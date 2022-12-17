package menu;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
    private static final String EXIT_MESSAGE = "\n추천을 완료했습니다.";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE);

        System.out.println(EXIT_MESSAGE);
    }
}
