package menu.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Menu;
import menu.util.ExceptionMessage;

public class MenuRepository {
    private MenuRepository() {
    }

    private static final List<Menu> menus = new ArrayList<>();

    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }

    public static void add(Menu menu) {
        menus.add(menu);
    }

    public static Menu findMenuByName(String name) {
        return menus.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_MENU.getMessage()));
    }

}
