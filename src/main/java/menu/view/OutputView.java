package menu.view;

import static java.lang.System.*;

public class OutputView {

    private static final String SERVICE_START = "점심 메뉴 추천을 시작합니다.";
    private static final String SERVICE_DONE = "추천을 완료했습니다.";
    private static final String INPUT_COACHNAME = "코치의 이름을 입력해 주세요. (, 로 구분)";

    private static final String INPUT_PROHIBITED_FOOD = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static void printServiceStart() {
        out.println(SERVICE_START);
    }

    public static void printInputCoachnames() {
        out.println(INPUT_COACHNAME);
    }

    public static void printInputProhibitedFoods(String name) {
        out.println(name + INPUT_PROHIBITED_FOOD);
    }

    public static void printServiceDone() {
        out.println(SERVICE_DONE);
    }

}
