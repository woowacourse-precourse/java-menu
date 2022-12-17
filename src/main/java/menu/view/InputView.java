package menu.view;

import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String DELIMITE_STRING = ",";
    private static final String INPUT_PATTERN = "^[가-힣][가-힣,]*[가-힣]$";

    public List<String> readCoachName() {
        return parseWithDelimiter(validateCoachNameFormat(Console.readLine()));
    }

    public List<String> readCoachNotEat() {
        return parseWithDelimiter(validateMenuFormat(Console.readLine()));
    }

    private List<String> parseWithDelimiter(String input) {
        return List.of(input.split(DELIMITE_STRING));
    }

    private String validateCoachNameFormat(String input) {
        if (!Pattern.matches(INPUT_PATTERN, input)) {
            throw new IllegalArgumentException("코치 이름은 한글과 콤마 형식이여야 합니다. (ex. 토미,제임스)");
        }
        return input;
    }

    private String validateMenuFormat(String input) {
        if (!Pattern.matches(INPUT_PATTERN, input)) {
            throw new IllegalArgumentException("메뉴는 한글과 콤마 형식이여야 합니다. (ex. 우동,스시)");
        }
        return input;
    }
}
