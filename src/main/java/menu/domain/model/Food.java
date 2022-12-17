package menu.domain.model;

import menu.domain.type.Category;

public class Food {

    private final String name;
    private final Category category;

    public Food(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}
