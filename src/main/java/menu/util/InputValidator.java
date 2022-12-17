package menu.util;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static menu.enums.ExceptionMessage.*;

public class InputValidator {

    private static final Integer STRING_LENGTH_START = 2;
    private static final Integer STRING_LENGTH_END = 4;
    private static final Integer LIST_LENGTH_START = 2;
    private static final Integer LIST_LENGTH_END = 5;
    private static final Integer MENU_LENGTH_START = 0;
    private static final Integer MENU_LENGTH_END = 2;


    public List<String> parseCoach(String input) {
        String[] coaches = input.split(",");
        List<String> collect = Arrays.stream(coaches)
                .filter(this::isValidCoachName).collect(toList());
        if (collect.size() == coaches.length) {
            isValidArraySize(collect);
            return collect;
        }
        throw new IllegalArgumentException(IS_NOT_VALID_COACH_NAME.getMessage());
    }

    public List<String> parseMenu(String menus) {
        List<String> collect = Arrays.stream(menus.split(","))
                .collect(toList());
        if (isValidMenusSize(collect)) {
            return collect;
        }
        throw new IllegalArgumentException(IS_NOT_VALID_MENU_LIST.getMessage());
    }

    private boolean isValidMenusSize(List<String> menus) {
        return MENU_LENGTH_START <= menus.size() && menus.size() <= MENU_LENGTH_END;
    }

    private boolean isValidCoachName(String str) {
        return STRING_LENGTH_START <= str.length() && str.length() <= STRING_LENGTH_END;
    }

    private void isValidArraySize(List<String> list) {
        if (LIST_LENGTH_START <= list.size() && list.size() <= LIST_LENGTH_END) {
            return;
        }
        throw new IllegalArgumentException(IS_NOT_VALID_COACH_COUNT.getMessage());
    }

}
