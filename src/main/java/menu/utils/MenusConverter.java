package menu.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenusConverter {

    private MenusConverter() {
    }

    public static List<String> convert(String input) {
        List<String> menus = getMenus(input);
        validate(menus);
        return menus;
    }

    private static List<String> getMenus(String input) {
        return Arrays.stream(input.split(","))
                .map(s -> s.trim())
                .filter(s -> s.length() != 0)
                .collect(Collectors.toList());
    }

    private static void validate(List<String> menus) {
        if (menus.size() < 0 || menus.size() > 2) {
            throw new IllegalArgumentException("각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.");
        }
    }
}
