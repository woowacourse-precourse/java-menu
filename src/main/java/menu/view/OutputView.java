package menu.view;

public class OutputView {

    private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
}
