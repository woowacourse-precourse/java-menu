package menu.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private static final String COACH_NAME_ERROR_MESSAGE = "[ERROR] 코치의 이름은 한글 2~4글자이며 ','을 기준으로 2~5명을 입력하여야합니다. ";
    private static final String MENU_ERROR_MESSAGE = "[ERROR] 메뉴 이름은 0~2개만 입력이 가능합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 입력의 중복은 불가능합니다.";
    private static final String NAME_INPUT_REGEX = "^[가-힣]{2,4}$";
    private static final int MINIMUM_COACH_NUMBER = 2;
    private static final int MAXIMUM_COACH_NUMBER = 5;
    private static final int MAXIMUM_CANNOT_EATS_NUMBER = 2;

    public static void validateCoachNames(String input, String command) throws IllegalArgumentException {
        List<String> names = StringParser.makeListByCommand(input, command);
        if (names.size() < MINIMUM_COACH_NUMBER || names.size() > MAXIMUM_COACH_NUMBER) {
            throw new IllegalArgumentException(COACH_NAME_ERROR_MESSAGE);
        }
        checkDuplicate(names);
        names.forEach(Validator::validateName);
    }

    public static void validateMenuNum(String input, String command) throws IllegalArgumentException {
        List<String> menus = StringParser.makeListByCommand(input, command);
        if (menus.size() > MAXIMUM_CANNOT_EATS_NUMBER) {
            throw new IllegalArgumentException(MENU_ERROR_MESSAGE);
        }
        checkDuplicate(menus);
    }

    private static void validateName(String name) {
        if (!Pattern.matches(NAME_INPUT_REGEX, name)) {
            throw new IllegalArgumentException(COACH_NAME_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicate(List<String> input) {
        Set<String> numSet = new HashSet<>(input);
        if (numSet.size() != input.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}

