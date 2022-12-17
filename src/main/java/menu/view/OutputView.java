package menu.view;

import static java.lang.System.*;

import menu.domain.Coach;
import menu.domain.Coaches;

public class OutputView {

    private static final String SERVICE_START = "점심 메뉴 추천을 시작합니다.";
    private static final String SERVICE_DONE = "추천을 완료했습니다.";
    private static final String INPUT_COACHNAME = "코치의 이름을 입력해 주세요. (, 로 구분)";

    private static final String INPUT_PROHIBITED_FOOD = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    private static final String MENU_RESULT = "메뉴 추천 결과입니다.";

    public static void printServiceStart() {
        out.println(SERVICE_START);
    }

    public static void printInputCoachnames() {
        out.println();
        out.println(INPUT_COACHNAME);
    }

    public static void printInputProhibitedFoods(String name) {
        out.println();
        out.println(name + INPUT_PROHIBITED_FOOD);
    }

    public static void printFinalResult(Coaches coaches) {
        out.println();
        out.println(MENU_RESULT);
        out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategories(coaches);
        printMenus(coaches);
    }

    private static void printMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            String menus = String.join(" | ", coach.getDoneMenus());
            out.println("[ " + coach.getName() + " | " + menus+" ]");
        }
    }

    private static void printCategories(Coaches coaches) {
        String categories = String.join(" | ", coaches.getCategories());
        out.println("[ 카테고리 | " + categories + " ]");
    }

    public static void printServiceDone() {
        out.println();
        out.println(SERVICE_DONE);
    }

    public static void printError(String message) {
        System.out.println(message);
        out.println();
    }
}
