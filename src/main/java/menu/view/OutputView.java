package menu.view;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String GET_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printGetCoachNameMessage() {
        System.out.println(GET_COACH_NAME_MESSAGE);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
