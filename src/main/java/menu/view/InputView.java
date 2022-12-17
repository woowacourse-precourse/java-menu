package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String READ_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final InputValidator inputvalidator = new InputValidator();
    public List<String> readCoachNames() {
        System.out.println(READ_COACH_NAMES_MESSAGE);
        String command = Console.readLine();
        inputvalidator.validateCoachNamesCommand(command);
        return Arrays.asList(command.split(","));
    }

    public List<String> readNoEatFoods() {
        // 못 먹는 메뉴 입력 받기
    }
}
