package menu.view;

public class OutputView {
    public void printApplicationStartGuide() {
        println("점심 메뉴 추천을 시작합니다.");
    }
    
    private void println(String message) {
        System.out.println(message);
    }
}
