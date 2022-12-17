package menu.client;

import camp.nextstep.edu.missionutils.Console;
import menu.di.ValidateMenuCommand;

public class InputView {

    private static final String ASK_MENU_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    private InputView() {
    }

    public static ValidateMenuCommand askMenus(String name) {
        System.out.println();
        System.out.println(name + ASK_MENU_MESSAGE);
        String input = Console.readLine();
        return new ValidateMenuCommand(input);
    }
}
