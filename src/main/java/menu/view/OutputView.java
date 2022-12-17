package menu.view;

import menu.domain.CoachRepository;

import java.util.List;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String HATE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputCoachName() {
        System.out.println(COACH_NAME);
    }

    public static void printInputHateMenu(String name) {
        System.out.println(String.format(HATE_MENU, name));

    }

    public static void printErrorMessage(String error) {
        System.out.println(error);
    }
}
