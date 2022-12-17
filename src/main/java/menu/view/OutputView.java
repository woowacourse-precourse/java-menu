package menu.view;

import menu.domain.Coach;

public class OutputView {


    private static final String START = "점심 메뉴 추천을 시작합니다.";
    private static final String ASK_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String ASK_CANT_EAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public void printStartMessage() {
        System.out.println(START);
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }

    public void printAskNames() {
        System.out.println(ASK_NAMES);
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printAskCoachCantEat(Coach coach) {
        System.out.printf(ASK_CANT_EAT, coach.getName());
    }
}
