package menu.view;

public class OutputView {
    private static final String START_COMMENT = "점심 메뉴 추천을 시작합니다.";
    private static final String COACH_NAMES_COMMENT = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public static void printStartComment() {
        System.out.println(START_COMMENT);
    }

    public static void printCoachNameComment() {
        System.out.println(COACH_NAMES_COMMENT);
    }
}
