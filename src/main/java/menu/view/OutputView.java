package menu.view;

import menu.coach.Coach;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private static final String END_MESSAGE = "추천을 완료했습니다.\n";

    private static final String SET_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)\n";
    private static final String SET_COACHES_CANNOT_EAT = "(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE_SET_COACHES_NAME = "코치는 최소 2명 이상, 5명 이하 입력해야 합니다.\n";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public static void printSetCoachesName() {
        System.out.println(SET_COACHES_NAME);
    }

    public static void printErrorMessage_setCoachesName() {
        System.out.println(ERROR_MESSAGE_START + ERROR_MESSAGE_SET_COACHES_NAME);
    }

    public static void printSetCoachesCannotEat(Coach coach) {
        System.out.println(coach.getName() + SET_COACHES_CANNOT_EAT);
    }

}
