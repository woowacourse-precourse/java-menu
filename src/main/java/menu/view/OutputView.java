package menu.view;

public class OutputView {


    private static final String START = "점심 메뉴 추천을 시작합니다.";
    private static final String ASK_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public void printStartMessage() {
        System.out.println(START);
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }

    public void printAskNames() {
        System.out.println(ASK_NAMES);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
