package menu.view;

public class OutputView {
    public OutputView() {};

    public static void printStartMsg() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printInputCoaches() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void printError(String msg) {
        System.out.println("[ERROR] " + msg);
    }

    public static void printInputInEdible(String coach) {
        System.out.println("\n" + coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }
}
