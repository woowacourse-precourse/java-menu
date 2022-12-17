package menu.view;

public class OutputView implements Output{
    @Override
    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다." + System.lineSeparator());
    }
}
