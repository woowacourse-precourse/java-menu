package menu.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menus {
    private final List<Menu> menus;

    public Menus() {
        menus = new ArrayList<>();
    }

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus from(String category, String menus) {
        return Arrays.stream(menus.split(", "))
                .map(name -> new Menu(Category.fromName(category), name))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Menus::new));
    }

    public Menus combine(Menus toCombine) {
        return Stream.concat(menus.stream(), toCombine.menus.stream())
                .distinct()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Menus::new));
    }

    public List<String> getNames() {
        return menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public Menu findMenu(String menuName) {
        return menus.stream()
                .filter(menu -> menu.isNameOf(menuName))
                .findAny()
                .orElse(null);
    }

    public void add(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
