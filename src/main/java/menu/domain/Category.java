package menu.domain;

import java.util.*;

public class Category {

    public String name;
    public int categoryNumber;
    public List<String> menus;

    public Category(String name, int categoryNumber, List<String> menus) {
        this.name = name;
        this.categoryNumber = categoryNumber;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public List<String> getMenus() {
        return menus;
    }
}
