package menu.controller.mapper;

import menu.domain.Food;

import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableList;

public class MenuMapper {

    private static final String ERROR_SIZE_OVER_FORMAT = "못 먹는 메뉴는 최대 %d개 까지만 입력하실 수 있습니다.";

    private static final int MAX_INEDIBLE_FOOD_SIZE = 2;
    private static final String COMMA = ",";

    public static List<Food> toMenus(String input) {
        String[] menus = input.split(COMMA);
        validateSize(menus);
        return stream(menus)
                .map(Food::ofName)
                .collect(toUnmodifiableList());
    }

    private static void validateSize(String[] split) {
        if (split.length > MAX_INEDIBLE_FOOD_SIZE) {
            throw new IllegalArgumentException(format(ERROR_SIZE_OVER_FORMAT, MAX_INEDIBLE_FOOD_SIZE));
        }
    }
}
