package menu.view;

public class OutputView {
    public static void messageProgramStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void messageNamesInput() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void messageBanInput(String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }
}
