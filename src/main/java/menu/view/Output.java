package menu.view;

public class Output {

    private static final String START_GUIDE_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    private static final String COACH_NAME_INPUT_GUIDE_MESSAGE = "코치의 이름을 입력해주세요. (, 로 구분)";

    private static final String HATING_MENUS_INPUT_GUIDE_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String ERROR = "[ERROR] ";
    public void printStartMessage() {
        System.out.println(START_GUIDE_MESSAGE);
        System.out.println();
    }

    public void printCoachNamesMessage() {
        System.out.println(COACH_NAME_INPUT_GUIDE_MESSAGE);
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(ERROR + e.getMessage());
        System.out.println();
    }

    public void printHatingMenusMessage(String coachName) {
        System.out.println(coachName + HATING_MENUS_INPUT_GUIDE_MESSAGE);
    }
}
