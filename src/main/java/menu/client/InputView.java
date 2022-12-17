package menu.client;

import camp.nextstep.edu.missionutils.Console;
import menu.di.ValidateMenuCommand;
import menu.di.ValidateNameCommand;

class InputView {

    private static final String ASK_MENU_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String ASK_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    private InputView() {
    }

    static ValidateNameCommand askNames() {
        println();
        println(ASK_COACH_NAME_MESSAGE);
        String input = Console.readLine();
        return new ValidateNameCommand(input);
    }

    static ValidateMenuCommand askMenus(String name) {
        println();
        println(name + ASK_MENU_MESSAGE);
        String input = Console.readLine();
        return new ValidateMenuCommand(input);
    }

    private static void println() {
        System.out.println();
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
