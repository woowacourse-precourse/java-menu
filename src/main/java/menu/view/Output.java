package menu.view;

import menu.domain.Coach;

public class Output {
    private static final String NEW_LINE = "\n";

    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void askCoachName() {
        System.out.println(NEW_LINE + "코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void askCantEatMenu(Coach coache) {
        System.out.println(String.format(NEW_LINE + "%s(이)가 못 먹는 메뉴를 입력해 주세요.", coache.getName()));
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
