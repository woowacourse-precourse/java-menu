package menu.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printNotMenuMessage(String coach) {
        System.out.println(coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

}
