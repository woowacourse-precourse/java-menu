package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String REQUIRE_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String REQUIRE_COACH_EXCLUDE_MENU_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public static String[] readCoachNames() {
        System.out.println(REQUIRE_COACH_NAME);
        String[] names = readLine().split(",");
        validateCoachSize(names);
        for (String name : names) {
            validateCoachLength(name);
        }
        return names;
    }

    public static String[] readExcludeMenu(String coach) {
        System.out.printf(REQUIRE_COACH_EXCLUDE_MENU_FORMAT, coach);
        String[] menus = readLine().split(",");
        validateMenuSize(menus);
        return menus;
    }

    private static void validateCoachSize(String[] names) {
        if (names.length < 2 || names.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 2-5명이어야 합니다.");
        }
    }

    private static void validateCoachLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2이상 4이하여야 합니다.");
        }
    }

    private static void validateMenuSize(String[] menus) {
        if (menus.length > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 0-2개만 입력가능합니다.");
        }
    }
}
