package menu.view;

public class OutputView extends DefaultMessage {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public static void printStartMessage() {
        addNewLine();
        printMessage(START_MESSAGE);
    }
}
