package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String READ_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String READ_NO_EAT_FOODS_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final InputValidator inputvalidator = new InputValidator();
    private static final OutputView outputView = new OutputView();

    public List<String> readCoachNames() {
        System.out.println(READ_COACH_NAMES_MESSAGE);
        String command = Console.readLine();
        try {
            inputvalidator.validateCoachNamesCommand(command);
        } catch (Exception e) {
            outputView.printError(e.getMessage());
            return readCoachNames();
        }
        return Arrays.asList(command.split(","));
    }

    public List<String> readNoEatFoods(String coachName) {
        System.out.println(coachName + READ_NO_EAT_FOODS_MESSAGE);
        String command = Console.readLine();
        try {
            inputvalidator.validateNoEatFoodsCommand(command);
        } catch (Exception e) {
            outputView.printError(e.getMessage());
            return readNoEatFoods(coachName);
        }
        return Arrays.asList(command.split(","));
    }
}
