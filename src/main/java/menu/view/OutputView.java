package menu.view;

public class OutputView {

    private static final String LUNCH_MENU_RECOMMEND_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void printLunchMenuRecommendMessage() {
        printMessage(LUNCH_MENU_RECOMMEND_MESSAGE);
    }

    private void printBlankLine() {
        System.out.println();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
