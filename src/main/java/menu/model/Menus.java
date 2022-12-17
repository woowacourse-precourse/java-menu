package menu.model;

import menu.utils.Serializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Menus extends Serializer {
    private static final String REGEX_KOREAN = "^[ㄱ-ㅎ가-힣, ]*$";

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
            throw new IllegalArgumentException("메뉴 이름은 한글만 입력할 수 있습니다.");
        }
    }

    private static void validateMenuSize(final String[] menu) {
        if (menu.length > 2) {
            throw new IllegalArgumentException("못 먹는 음식은 0 ~ 2개만 가능합니다.");
        }
    }

    public void addMenus(final Menus menus) {
        this.menus.addAll(menus.getMenus());
    }

    public boolean contains(final String menu) {
        return this.menus.contains(menu);
    }

    public List<String> getCloneMenus() {
        List<String> clone = new ArrayList<>();
        clone.addAll(this.menus);
        return clone;
    }
}
