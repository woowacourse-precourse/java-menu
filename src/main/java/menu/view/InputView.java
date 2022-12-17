package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private final String READ_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String READ_MENU_CANT_EAT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private final String DELIMITER = ",";

    public List<String> readNames() {
        System.out.println(READ_NAME_MESSAGE);
        String line = Console.readLine();
        return List.of(line.split(DELIMITER));
    }

    public List<String> readMenuCantEat(String name) {
        System.out.printf(READ_MENU_CANT_EAT_MESSAGE, name);
        String line = Console.readLine();
        return List.of(line.split(DELIMITER));
    }
}
