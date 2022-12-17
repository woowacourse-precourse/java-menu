package menu.view;

public class OutputView {

    private static final String MENU_COMMEND_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    private OutputView() {
    }

    public static void printStartMenuComment() {
        System.out.println(MENU_COMMEND_MESSAGE);
    }
}
