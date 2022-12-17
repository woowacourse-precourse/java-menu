package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;

public class InputView {

    private static final String READ_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_MENU_NAMES_MESSAGE = "{0}(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String readCoachNames() {
        System.out.println(READ_COACH_NAMES_MESSAGE);
        String names = Console.readLine();
        return names;
    }

    public String readMenuNames(String name) {
        System.out.println(MessageFormat.format(READ_MENU_NAMES_MESSAGE, name));
        String menuNames = Console.readLine();
        return menuNames;
    }
}
