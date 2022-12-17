package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Validate;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public static List<String> readCoachName() {
        System.out.println(Message.COACH_NAME_INPUT_MESSAGE.message);
        String name = Console.readLine();
        String[] splitNames = name.split(",");
        List<String> names = Arrays.asList(splitNames);
        Validate.nameLength(names,2,4);
        Validate.coachLength(names,2,5);
        return names;
    }

    public static List<String> readCantEats(String name) {
        System.out.println(String.format(Message.CANT_EAT_INPUT_MESSAGE.message, name));
        String menu = Console.readLine();
        String[] menus = menu.split(",");
        return Arrays.asList(menus);
    }

    private enum Message {
        COACH_NAME_INPUT_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)"),
        CANT_EAT_INPUT_MESSAGE("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
