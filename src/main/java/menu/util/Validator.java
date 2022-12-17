package menu.util;

import java.util.List;

public class Validator {

    private static final String COACH_NUMBER_ERROR = "코치 인원은 최소 2명 최대 5명까지 가능합니다.";

    private static final String COACH_NAME_LENGTH_ERROR = "코치 이름은 최소 2글자 최대 4글자이여야합니다.";

    private static final String CAN_EAT_EVERYTHING = "";

    private static final String HATING_FOOD_LENGTH_ERROR = "못 먹는 메뉴는 최대 2개 까지 가능합니다.";

    private static final String NOT_EXIST_MENUS = "메뉴판에 존재하지 않는 메뉴입니다.";

    public static void checkCoachNames(String input) {
        checkCoachNumber(input);
        checkCoachNameLength(input);
    }

    private static void checkCoachNameLength(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR);
            }
        }
    }

    private static void checkCoachNumber(String input) {
        int length = input.split(",").length;
        if (length < 2 || length > 5) {
            throw new IllegalArgumentException(COACH_NUMBER_ERROR);
        }
    }

    public static void checkHatingMenus(String menus) {
        checkMenusLength(menus);
        for (String menu : menus.split(",")) {
            checkExistMenu(menu);
        }
    }

    public static void checkExistMenu(String menu) {
        List<String> totalMenus = TotalMenuInfo.getTotalMenus();
        if (!totalMenus.contains(menu)) {
            throw new IllegalArgumentException(NOT_EXIST_MENUS);
        }
    }

    public static void checkMenusLength(String menus) {
        int length = menus.split(",").length;
        if (length > 2) {
            throw new IllegalArgumentException(HATING_FOOD_LENGTH_ERROR);
        }
    }
}
