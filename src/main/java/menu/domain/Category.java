package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private final String name;
    private final List<String> menus;

    private Category(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }

    public static Category of (String name, List<String> menus) {
        return new Category(name, menus);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", menus=" + menus +
                '}';
    }
}
