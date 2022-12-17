package menu.ui;

public class OutputView {

    private static final String GAME_START = "점심 메뉴 추천을 시작합니다.";
    public static void printMenuGameStart() {
        System.out.println(GAME_START);
    }

    public static void printCoachNumberIsNotValid() {
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
