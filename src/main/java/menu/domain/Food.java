package menu.domain;

import menu.domain.enums.Category;

public class Food {

    private final Category category;
    private final String name;

    public Food(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Category category() {
        return category;
    }

    public String name() {
        return name;
    }
}
