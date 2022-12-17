package menu.domain;

import menu.utills.constants.Category;

public class Menu {
    private final Category category;
    private final String name;

    public Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name);
    }
}
