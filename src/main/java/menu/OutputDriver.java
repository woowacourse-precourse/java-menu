package menu;

public class OutputDriver {
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printScanCannotEatMenuMessage(String name) {
        System.out.println(name+"(이)가 못 먹는 메뉴를 입력해 주세요.");
    }
}
