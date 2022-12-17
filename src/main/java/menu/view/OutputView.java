package menu.view;

public class OutputView {
    private static final String ERROR_MESSAGE_HEAD = "[ERROR] ";
    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    private OutputView() {}

    public void init() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }

    public void printErr(String message) {
        System.out.println(ERROR_MESSAGE_HEAD + message);
        printBlankLine();
    }
}
