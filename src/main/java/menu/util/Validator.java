package menu.util;

import menu.type.CategoryList;

import java.util.List;

public class Validator {

    private static final String COACH_NUMBER_ERROR = "코치 인원은 최소 2명 최대 5명까지 가능합니다.";

    private static final String COACH_NAME_LENGTH_ERROR = "코치 이름은 최소 2글자 최대 4글자이여야합니다.";

    private static final String HATING_FOOD_LENGTH_ERROR = "못 먹는 메뉴는 최대 2개 까지 가능합니다.";

    private static final String NOT_EXIST_MENUS = "메뉴판에 존재하지 않는 메뉴입니다.";

    private static final String COMMA = ",";

    private static final int NAME_LENGTH_MIN_VALUE = 2;

    private static final int NAME_LENGTH_MAX_VALUE = 4;

    private static final int MENU_LENGTH_MAX_VALUE = 2;

    private static final int COACH_NUMBER_MIN_VALUE = 2;

    private static final int COACH_NUMBER_MAX_VALUE = 5;

    public static void checkCoachNames(String input) {
        checkCoachNumber(input);
        checkCoachNameLength(input);
    }

    private static void checkCoachNumber(String input) {
        int length = input.split(COMMA).length;
        if (length < COACH_NUMBER_MIN_VALUE || length > COACH_NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException(COACH_NUMBER_ERROR);
        }
    }

    private static void checkCoachNameLength(String input) {
        for (String name : input.split(COMMA)) {
            if (name.length() < NAME_LENGTH_MIN_VALUE || name.length() > NAME_LENGTH_MAX_VALUE) {
                throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR);
            }
        }
    }

    public static void checkHatingMenus(String menus) {
        checkMenusLength(menus);
        for (String menu : menus.split(COMMA)) {
            checkExistMenu(menu);
        }
    }

    public static void checkExistMenu(String menu) {
        List<String> totalMenus = CategoryList.getAllMenus();
        if (!totalMenus.contains(menu)) {
            throw new IllegalArgumentException(NOT_EXIST_MENUS);
        }
    }

    public static void checkMenusLength(String menus) {
        int length = menus.split(COMMA).length;
        if (length > MENU_LENGTH_MAX_VALUE) {
            throw new IllegalArgumentException(HATING_FOOD_LENGTH_ERROR);
        }
    }
}
