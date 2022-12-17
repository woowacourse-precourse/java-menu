package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {
    private final String ASK_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String DELIMITER = ",";
    private final String MULTIPLE_INPUT_REGEX = "^[가-힣,]*$";
    private final String ASK_DISLIKE_FOOD = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String readCoachName() {
        System.out.println(ASK_COACH_NAME);
        return readMultipleData(Console.readLine());
    }

    public String readDislikeFoods(String coachName) {
        System.out.printf(ASK_DISLIKE_FOOD + "\n", coachName);
        return readIncludingNone(Console.readLine());
    }

    private String readMultipleData(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(String.format("[ERROR] 구분자는 %s 를 사용해야 합니다.", DELIMITER));
        }
        validateNameCondition(input);
        return input;
    }

    private String readIncludingNone(String input) {
        validateNameCondition(input);
       return input;
    }

    private void validateNameCondition(String input) {
        if (!Pattern.matches(MULTIPLE_INPUT_REGEX, input)) {
            throw new IllegalArgumentException("[ERROR] 한글과 , 만 입력할 수 있습니다.");
        }
    }
}
