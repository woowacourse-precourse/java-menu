package menu.view;

import menu.dto.CoachNameDto;

public class OutputView {
    private static final String PROGRAM_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String READ_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_CANT_EAT_MENUS_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static void printException(Exception e) {
        System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
    }

    public static void printProgramStartMessage() {
        System.out.println(PROGRAM_START_MESSAGE);
    }

    public static void printReadCoachNames() {
        System.out.println(READ_COACH_NAMES_MESSAGE);
    }

    public static void printReadCantEatMenus(CoachNameDto coachNameDto) {
        String name = coachNameDto.getName();
        System.out.println(name + READ_CANT_EAT_MENUS_MESSAGE);
    }
}
