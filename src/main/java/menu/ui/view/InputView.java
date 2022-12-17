package menu.ui.view;

public class InputView {

    private InputView() {

    }
    public static InputView getInstance() {
        return new InputView();
    }

    public void onBoardingPage() {
        System.out.println("점심 메뉴 추천을 시작합니다."); // TODO 매직넘버 정리 필요
        lineBreak();
    }

    private void lineBreak() {
        System.out.println();
    }
}
