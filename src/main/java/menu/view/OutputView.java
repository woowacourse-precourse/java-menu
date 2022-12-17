package menu.view;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String END_MESSAGE_FORMAT = "메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n%s\n%s\n";
    private static final String PROMPT_FOR_COACH_NAME_INPUT = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String PROMPT_FOR_MENU_INPUT_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";
    public static final String END_MESSAGE = "추천을 완료했습니다.";

    public static void printExceptionMessageForInvalidInput(String exceptionMessage) {
        System.out.println("[ERROR] " + exceptionMessage);
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printRecommendationResult(String resultForCategories, List<String> resultForCoaches) {
        String result = String.join("\n", resultForCoaches);
        System.out.printf(END_MESSAGE_FORMAT, resultForCategories, result);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public static void printPromptForCoachNameInput() {
        System.out.println(PROMPT_FOR_COACH_NAME_INPUT);
    }

    public static void printPromptForMenuCannotToEatInput(String coachName) {
        System.out.printf(PROMPT_FOR_MENU_INPUT_FORMAT, coachName);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
