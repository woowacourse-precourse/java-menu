package menu.domain.repository;

import menu.domain.model.Menu;

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
}
