package menu;

public class OutputDriver {
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printScanCannotEatMenuMessage(String name) {
        System.out.println("\n" + name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printResult(String menuListStringReturn) {
        System.out.println("\n메뉴 추천 결과입니다.\n");
        System.out.println(menuListStringReturn);
        System.out.println("\n추천을 완료했습니다.");
    }
}
