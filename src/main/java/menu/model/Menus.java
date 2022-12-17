package menu.model;

import menu.utils.Serializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static menu.utils.Errors.ENTER_KOREAN_MENU;
import static menu.utils.Errors.NOT_RIGHT_NUMBER_OF_MENU;

public class Menus extends Serializer {
    private static final String REGEX_KOREAN = "^[ㄱ-ㅎ가-힣, ]*$";
    private static final int MAX_CANNOT_EAT_FOOD_NUMBER = 2;

    private List<String> menus = new ArrayList<>();

    public Menus() {
    }

    public Menus(final List<String> menus) {
        this.menus = menus;
    }

    public List<String> getMenus() {
        return menus;
    }

    public static Menus create(final String input) {
        validateKorean(input);

        final String[] menu = serialize(input);
        validateMenuSize(menu);

        final List<String> menus = Arrays.stream(menu)
                .collect(Collectors.toList());

        return new Menus(menus);
    }

    private static void validateKorean(final String input) {
        if (!Pattern.matches(REGEX_KOREAN, input)) {
            throw new IllegalArgumentException(ENTER_KOREAN_MENU.getMessage());
        }
    }

    private static void validateMenuSize(final String[] menu) {
        if (menu.length > MAX_CANNOT_EAT_FOOD_NUMBER) {
            throw new IllegalArgumentException(NOT_RIGHT_NUMBER_OF_MENU.getMessage());
        }
    }

    public void addMenus(final Menus menus) {
        this.menus.addAll(menus.getMenus());
    }

    public boolean contains(final String menu) {
        return this.menus.contains(menu);
    }
}
