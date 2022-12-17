package menu.view;

import java.util.List;
import menu.domain.Coach;

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

    public void printRecommendedMenus(List<Coach> coaches) {
        System.out.println(Message.OUTPUT_MENU_RESULT.message);

    }

    private enum Message {
        OUTPUT_START("점심 메뉴 추천을 시작합니다."),
        OUTPUT_MENU_RESULT("\n메뉴 추천 결과입니다."),
        OUTPUT_DIVISION("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }


}
