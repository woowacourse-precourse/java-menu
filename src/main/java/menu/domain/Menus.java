package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {
    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus from(String category, String menus) {
        return Arrays.stream(menus.split(", "))
                .map(name -> new Menu(Category.fromName(category), name))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Menus::new));
    }
}
