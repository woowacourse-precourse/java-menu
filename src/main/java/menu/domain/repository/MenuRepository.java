package menu.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    public static boolean deleteByName(String name) {
        return menus.removeIf(element -> Objects.equals(element.getName(), name));
    }

    public static void deleteAll() {
        menus.clear();
    }

    public static Menu findByName(String name) {
        return menus.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_MENU.getMessage()));
    }

}
