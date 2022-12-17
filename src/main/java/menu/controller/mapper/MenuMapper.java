package menu.controller.mapper;

import menu.domain.Food;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableList;

public class MenuMapper {

    private static final String COMMA = ",";
    private static final int MAX_INEDIBLE_FOOD_SIZE = 2;

    public static List<Food> toMenus(String input) {
        String[] menus = input.split(COMMA);
        validateSize(menus);
        return stream(menus)
                .map(Food::ofName)
                .collect(toUnmodifiableList());
    }

    private static void validateSize(String[] split) {
        if (split.length > MAX_INEDIBLE_FOOD_SIZE) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개까지만 입력하실 수 있습니다.");
        }
    }
}
