package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.service.dto.MenuDto;
import menu.service.dto.CoachNameDto;

public class InputView {

    private static final String MENU_MSG = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String COACH_NAME_MSG = "코치의 이름을 입력해 주세요. (, 로 구분)";

    private InputView() {
    }

    private static void println() {
        System.out.println();
    }

    private static void println(final String message) {
        System.out.println(message);
    }

    public static CoachNameDto getNames() {
        println();
        println(COACH_NAME_MSG);
        final String userInput = Console.readLine();
        return new CoachNameDto(userInput);
    }

    public static MenuDto getMenus(final String name) {
        println();
        println(name + MENU_MSG);
        final String userInput = Console.readLine();
        return new MenuDto(userInput);
    }
}