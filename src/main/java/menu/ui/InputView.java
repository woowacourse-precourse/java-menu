package menu.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String PUT_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String PUT_ALLERGIC_MENU  = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static String readCoachesName() {
        System.out.println(PUT_COACHES_NAME);
        return readLine();
    }

    public static String readAllergicMenus(String coachName) {
        System.out.println(coachName + PUT_ALLERGIC_MENU);
        return readLine();
    }
}
