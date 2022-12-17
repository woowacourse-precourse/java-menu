package menu.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        System.out.println();
    }
}
