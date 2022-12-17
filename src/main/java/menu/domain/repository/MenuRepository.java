package menu.domain.repository;

import menu.domain.model.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {

    private static final List<Menu> menus;

    static {
        menus = MenuCreator.create();
    }

    private MenuRepository() {
    }

    public static List<Menu> findAll() {
        return Collections.unmodifiableList(menus);
    }

    public static List<Menu> findByNames(List<String> names) {
        List<Menu> result = new ArrayList<>();
        for (String name : names) {
            Menu findMenu = findMenuByName(name);
            result.add(findMenu);
        }
        return result;
    }

    private static Menu findMenuByName(String name) {
        return menus.stream()
                .filter(menu -> menu.isEqualName(name))
                .findFirst()
                .orElseThrow();
    }
}
