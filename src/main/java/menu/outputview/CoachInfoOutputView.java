package menu.outputview;

public class CoachInfoOutputView {

    public static final String ASKING_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String ASKING_MENU_BANNED_MESSAGE_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";

    public static void printAskingCoachNames() {
        System.out.println();
        System.out.println(ASKING_COACH_NAME_MESSAGE);
    }

    public static void printAskingMenuBanned(String name) {
        System.out.println();
        System.out.printf(ASKING_MENU_BANNED_MESSAGE_FORMAT, name);
    }
}
