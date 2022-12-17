package menu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class Converter {

    public static List<Coach> stringToCoaches(String coaches) {
        String[] splitCoaches = coaches.split(",");
        return Arrays.stream(splitCoaches)
            .map(Coach::new)
            .collect(Collectors.toList());
    }

    public static List<String> stringToBannedMenus(String menus) {
        if (menus.trim().length() == 0) {
            return new ArrayList<>();
        }
        String[] splitMenus = menus.split(",");
        return Arrays.stream(splitMenus)
            .collect(Collectors.toList());
    }
}
