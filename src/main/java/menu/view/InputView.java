package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends DefaultMessage {

    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_CANNOT_EAT_MENUS = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static String inputCoachName() {
        addNewLine();
        printMessage(INPUT_COACH_NAME);
        return Console.readLine();
    }

    public static String inputCannotEatMenu(final String name) {
        addNewLine();
        printMessage(String.format(INPUT_CANNOT_EAT_MENUS, name));
        return Console.readLine();
    }
}
