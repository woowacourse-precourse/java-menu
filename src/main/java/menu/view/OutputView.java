package menu.view;

public class OutputView {
    private static final String START_COMMENT = "점심 메뉴 추천을 시작합니다.";
    private static final String COACH_NAMES_COMMENT = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String COACH_FORBIDDEN_FOOD_COMMENT = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static void printStartComment() {
        System.out.println(START_COMMENT);
    }

    public static void printCoachNameComment() {
        System.out.println(COACH_NAMES_COMMENT);
    }

    public static void printCoachForbiddenFoodComment(String name) {
        System.out.printf("%s" + COACH_FORBIDDEN_FOOD_COMMENT, name);
    }
}
