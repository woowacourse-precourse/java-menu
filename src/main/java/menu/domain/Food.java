package menu.domain;

import menu.enums.Category;

public class Food {
    private final Category category;
    private final String name;

    public Food(String name) {
        this.category = Category.selectCategoryByFood(name);
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }
}
