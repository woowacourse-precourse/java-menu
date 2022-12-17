package menu.controller.mapper;

import menu.domain.Menu;
import menu.domain.enums.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toUnmodifiableList;

public class MenuMapper {

    private static final String ERROR_SIZE_OVER_FORMAT = "못 먹는 메뉴는 최대 %d개 까지만 입력하실 수 있습니다.";

    private static final int MAX_INEDIBLE_MENU_SIZE = 2;
    private static final int ZERO = 0;
    private static final String COMMA = ",";

    public static List<Menu> toMenus(String input) {
        String[] menus = input.split(COMMA);
        validateSize(menus);

        if (ifNoMenu(menus)){
            return emptyList();
        }
        return stream(menus)
                .map(Category::mapMenuByName)
                .collect(toUnmodifiableList());
    }

    private static boolean ifNoMenu(String[] menus) {
        return menus[ZERO] != null;
    }

    private static void validateSize(String[] split) {
        if (split.length > MAX_INEDIBLE_MENU_SIZE) {
            throw new IllegalArgumentException(format(ERROR_SIZE_OVER_FORMAT, MAX_INEDIBLE_MENU_SIZE));
        }
    }
}
