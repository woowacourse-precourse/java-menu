package menu.view;

public class OutputView {
    private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private final String END_MESSAGE = "추천을 완료했습니다.";
    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
    public void printMenu() {
        // 최종 메뉴 출력ㅅ
    }
    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }
}
