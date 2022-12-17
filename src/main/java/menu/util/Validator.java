package menu.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private static final String COACH_NAME_ERROR_MESSAGE = "[ERROR] 코치의 이름은 ,을 기준으로 한글 2~4글자이며, 2~5명을 입력하여야합니다. 중복은 불가능합니다.";

    public static void validateCoachNames(String input, String command) throws IllegalArgumentException {
        List<String> names = StringParser.parseByCommand(input, command);
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException(COACH_NAME_ERROR_MESSAGE);
        }
        checkDuplicate(names);
        names.forEach(Validator::validateName);
    }

    private static void validateName(String name) {
        String condition = "^[가-힣]{2,4}$";
        if (!Pattern.matches(condition, name)) {
            throw new IllegalArgumentException(COACH_NAME_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicate(List<String> input) {
        Set<String> numSet = new HashSet<>(input);
        if(numSet.size()!= input.size()){
            throw new IllegalArgumentException(COACH_NAME_ERROR_MESSAGE);
        }
    }
}

