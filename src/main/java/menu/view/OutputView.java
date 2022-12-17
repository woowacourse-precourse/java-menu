package menu.view;

public class OutputView {

    public static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    public static final String READ_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String READ_IMPOSSIBLE_MENUS_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    public static final String RESULT_INTRODUCTION_MESSAGE = "메뉴 추천 결과입니다.";
    public static final String TABLE_HEAD_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    private void printlnMessage(String message) {
        System.out.println(message);
    }

    private void printMessage(String message) {
        System.out.print(message);
    }

    public void printStart() {
        printlnMessage(START_MESSAGE);
        printlnMessage("");
    }

    public void printReadCoachName() {
        printlnMessage(READ_COACH_NAME_MESSAGE);
    }

    public void printReadImpossibleMenus(String coachName) {
        printlnMessage(coachName + READ_IMPOSSIBLE_MENUS_MESSAGE);
    }

    public void printResultHead() {
        printlnMessage(RESULT_INTRODUCTION_MESSAGE);
        printlnMessage(TABLE_HEAD_MESSAGE);
    }

    public void printResultBody() {

    }
}
