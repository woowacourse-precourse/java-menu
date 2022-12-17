package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private final String name;
    private final List<Menu> menus = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addMenusToCategory(List<Menu> menus) {
        this.menus.addAll(menus);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
