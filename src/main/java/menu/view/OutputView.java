package menu.view;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    // static이면 이 위에 지우고 아래를 static으로 만들면됨

    public void printStart() {
        System.out.println(Message.OUTPUT_START.message);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private enum Message {
        OUTPUT_START("점심 메뉴 추천을 시작합니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }


}
