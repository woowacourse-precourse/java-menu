package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Menu;

public class MenuRepository {
    private static List<Menu> menus = new ArrayList<>();

    public MenuRepository(List<Menu> menus) {
        this.menus = menus;
    }

    public static void addMenu(Menu menu) {
        menus.add(menu);
    }

    public static List<Menu> findAll() {
        return Collections.unmodifiableList(menus);
    }

    public static Menu findMenu(String name) {
        return menus.stream()
                .filter(menu -> menu.getName().equals(name.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("[ERROR] %s 메뉴를 찾을 수 없습니다.", name)));
    }
}
