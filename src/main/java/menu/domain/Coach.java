package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MAX_CANT_EAT_MENU_SIZE = 2;
    private static final String INVALID_NAME_MESSAGE = "코치의 이름은 최소 2글자, 최대 4글자입니다.";
    private static final String INVALID_MENU_SIZE_MESSAGE = "먹지 못하는 메뉴의 개수는 0~2여야 합니다.";
    private static final String DUPLICATED_MENU_MESSAGE = "중복되지 않는 메뉴를 입력해주세요";
    private final String name;
    private final List<Menu> cantEatMenus = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
    }

    public void addCantEatMenus(List<Menu> menus) {
        validateCantEatMenus(menus);
        cantEatMenus.addAll(menus);
    }

    private static void validateCantEatMenus(List<Menu> menus) {
        if (menus.size() > MAX_CANT_EAT_MENU_SIZE) {
            throw new IllegalArgumentException(INVALID_MENU_SIZE_MESSAGE);
        }
        if (menus.size() != menus.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_MENU_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public List<String> exceptCantEatMenus(List<String> menuNames) {
        List<String> cantEatMenuNames = cantEatMenus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
        menuNames.removeAll(cantEatMenuNames);
        return menuNames;
    }
}
