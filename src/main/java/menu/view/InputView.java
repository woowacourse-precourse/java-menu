package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String NAMES_INPUT_DELIMITER = ",";
    private static final String INPUT_INEDIBLE_MENU_MESSAGE =
            "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String INPUT_COACH_NAMES_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";

    private static final List<String> EMPTY_LIST = List.of("");

    public List<String> readCoachNames() {
        System.out.println(INPUT_COACH_NAMES_MESSAGE);
        return Arrays.asList(readLine().split(NAMES_INPUT_DELIMITER));
    }

    public List<String> readInedibleMenus(String name) {
        System.out.println(String.format(INPUT_INEDIBLE_MENU_MESSAGE, name));
        List<String> inputs = Arrays.asList(readLine().split(NAMES_INPUT_DELIMITER));
        if (inputs.equals(EMPTY_LIST)) {
            return new ArrayList<>();
        }
        return inputs;
    }
}
