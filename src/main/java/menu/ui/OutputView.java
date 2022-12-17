package menu.ui;

import menu.domain.Coach;

public class OutputView {

    public static final String NEW_LINE = "\n";

    public static void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void enterCoach() {
        System.out.println(NEW_LINE + "코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void error(String message) {
        System.out.println("[ERROR]" + message);
    }

    public static void cantEatMenu(Coach coach) {
        System.out.println(NEW_LINE + coach.print() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }
}
