package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String ENTER_CREW_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String ENTER_BANNED_FOODS = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String COMMA = ",";

    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    public List<String> readCrewNames() {
        return Arrays.stream(splitByRegex(inputBox(ENTER_CREW_NAMES)))
                .map(input -> {
                    inputValidator.validate(input);
                    return input;
                }).collect(Collectors.toList());
    }

    public List<String> readBannedFoods(String crewName) {
        return Arrays.stream(splitByRegex(inputBox(crewName + ENTER_BANNED_FOODS)))
                .peek(inputValidator::validate).collect(Collectors.toList());
    }

    private String inputBox(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static String[] splitByRegex(String input) {
        return input.split(COMMA);
    }
}
