package menu.model.domain;

import java.util.ArrayList;
import java.util.List;

public class DislikeMenus {
    public static final int MENU_SIZE_MAX = 2;

    private List<String> dislikeMenu = new ArrayList<>();

    public DislikeMenus(List<String> menus) {
        validateMenus(menus);
        this.dislikeMenu = dislikeMenu;
    }

    public boolean contains(String menu) {
        return dislikeMenu.contains(menu);
    }

    private void validateMenus(List<String> menus) {
        if (menus.size() > MENU_SIZE_MAX) {
            throw new IllegalArgumentException("못 먹는 메뉴 개수는 최대 2여야 합니다.");
        }
        validateDuplicatedMenu(menus);
        menus.forEach(this::validateMenuName);
    }

    private void validateDuplicatedMenu(List<String> menus) {
        int removeDuplicated = (int) menus.stream()
                .distinct()
                .count();
        if (removeDuplicated != menus.size()) {
            throw new IllegalArgumentException("중복된 메뉴 이름을 입력할 수 없습니다.");
        }
    }

    private void validateMenuName(String menuName) {
        if (!Category.isExistMenu(menuName)) {
            throw new IllegalArgumentException("못 먹는 메뉴의 이름이 메뉴 정보에 존재하지 않습니다.");
        }
    }
}
