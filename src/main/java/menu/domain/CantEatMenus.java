package menu.domain;

import java.util.List;

public class CantEatMenus {
    private final List<Menu> menus;

    public CantEatMenus(List<Menu> menus) {
        validateSize(menus);
        this.menus = menus;
    }

    private void validateSize(List<Menu> menus) {
        if (!isValidSize(menus.size())) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 0개 ~ 2개까지 가능합니다.");
        }
    }

    private static boolean isValidSize(int size) {
        return 0 <= size && size <= 2;
    }
}
