package menu.view;

import java.util.List;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public static void startMessage() {
        System.out.println(Message.START_MESSAGE.message);
    }

    public static void resultMessage() {
        System.out.println(Message.RESULT_MESSAGE.message);
        System.out.println(Message.WEEK_MESSAGE.message);
    }

    public static void LineMessage(String title, List<String> categorys) {
        System.out.println(String.format(Message.BORDER_MESSAGE.message, title, insertLine(categorys)));
    }

    public static String insertLine(List<String> categorys) {
        return String.join(Message.LINE_MESSAGE.message, categorys);
    }

    public static void endMessage() {
        System.out.println(Message.COMPLETION_MESSAGE.message);
    }

    private enum Message {
        START_MESSAGE("점심 메뉴 추천을 시작합니다.\n"),
        RESULT_MESSAGE("\n메뉴 추천 결과입니다."),
        WEEK_MESSAGE("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
        BORDER_MESSAGE("[ %s | %s ]"),
        LINE_MESSAGE(" | "),
        COMPLETION_MESSAGE("\n추천을 완료했습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
