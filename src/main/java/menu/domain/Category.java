package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<String> menu;

    public Category(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public void addMenu(List<String> menus) {
        this.menu = menus;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return menu;
    }
}
