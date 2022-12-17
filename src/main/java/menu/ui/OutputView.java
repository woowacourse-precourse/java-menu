package menu.ui;

public class OutputView {

    public void announceStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        addEmptyLine();
    }

    private void addEmptyLine() {
        System.out.println();
    }
}
