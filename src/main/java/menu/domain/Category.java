package menu.domain;

import java.util.List;

public class Category {
    private final String name;
    private final List<String> menus;

    public Category(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }
}
