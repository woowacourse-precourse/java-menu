package menu.view;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */
public class OutputView {

    private static final String ERROR_TITLE = "[ERROR] ";
    private static final String START_RECOMMEND_LAUNCH_MENU = "점심 메뉴 추천을 시작합니다.";
    private static final String INPUT_COACH_NAME = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_COACH_HATE_MENUS = "\n%s가 못 먹는 메뉴를 입력해 주세요.";

    public static void printError(String errorMessage) {
        System.out.println(ERROR_TITLE + errorMessage);
    }

    public static void printStart() {
        System.out.println(START_RECOMMEND_LAUNCH_MENU);
    }

    public static void printInputCoach() {
        System.out.println(INPUT_COACH_NAME);
    }

    public static void printInputCoachHateMenus(String coachName) {
        System.out.printf((INPUT_COACH_HATE_MENUS) + "%n", coachName);
    }
}
