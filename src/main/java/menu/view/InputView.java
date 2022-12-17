package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Couch;

import java.util.regex.Pattern;

public class InputView {
    public static String readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String names = Console.readLine();
        validateNames(names);
        return names;
    }

    public static String[] readUneatableMenus(Couch couch) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", couch.getName());
        String menus = Console.readLine();
        validateMenus(menus);
        if (menus.endsWith(",")) {
            menus = menus.substring(0, menus.length() - 1);
        }
        return menus.split(",");
    }

    private static void validateNames(String names) {
        String format = "([가-힣0-9a-zA-Z]{2,4},){1,3}([가-힣0-9a-zA-Z]{2,4})";
        if (!Pattern.matches(format, names)) {
            throw new IllegalArgumentException("[ERROR] 이름은 최소 2자에서 4자까지며 코치는 최소 2명에서 최대 5명입니다.");
        }
    }

    private static void validateMenus(String menus) {
        String format = "[.]?([가-힣0-9-a-zA-Z]+)?(,[가-힣0-9-a-zA-Z]+)?";
        if (!Pattern.matches(format, menus)) {
            throw new IllegalArgumentException("[ERROR] 못먹는 메뉴는 최대 2개까지 가능합니다.");
        }
    }
}
