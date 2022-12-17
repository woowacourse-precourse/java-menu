package menu.output;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private static final String COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String NOT_EAT_MENUS_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printCoachNameMessage() {
        System.out.println(COACH_NAME_MESSAGE);
    }

    public static void printEachCoachNotEatMenusMessage(String coachName) {
        System.out.println("\n" + coachName + NOT_EAT_MENUS_MESSAGE);
    }
}

