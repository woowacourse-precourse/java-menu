package menu.view;

public class OutputView {

    private static final String LUNCH_MENU_RECOMMEND_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String READ_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String CANNOT_EAT_FOODS_BY_COACH_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public void printLunchMenuRecommendMessage() {
        printMessage(LUNCH_MENU_RECOMMEND_MESSAGE);
    }

    public void printReadCoachNameMessage() {
        printBlankLine();
        printMessage(READ_COACH_NAME_MESSAGE);
    }

    public void printCannotEatFoodsByCoachMessage(String coachName) {
        printMessage(coachName + CANNOT_EAT_FOODS_BY_COACH_MESSAGE);
    }

    private void printBlankLine() {
        System.out.println();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
