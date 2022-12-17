package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    public static void addMenu(Menu menu) {
        menus.add(menu);
    }

    public static Menu findByName(String name) {
        return menus.stream()
                .filter(menu -> menu.isEqualsName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력하신 메뉴는 없습니다"));
    }
}
