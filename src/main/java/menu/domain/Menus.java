package menu.domain;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;
import java.util.stream.Collectors;

public class Menus {

    private final List<Menu> menus;

    private Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus createMenus(List<String> names) {
        return new Menus(names.stream()
                .map(Menu::new)
                .collect(toUnmodifiableList()));
    }
}
