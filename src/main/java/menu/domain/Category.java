package menu.domain;

import java.util.List;

public class Category {

    private final String name;
    private final List<String> menu;

    public Category(String name, List<String> menu) {
        this.name = name;
        this.menu = menu;
    }
}
