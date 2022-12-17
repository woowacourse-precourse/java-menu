package menu.domain;

import menu.domain.enums.Category;

import java.util.Objects;

public class Food {

    private final Category category;
    private final String name;

    public Food(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public static Food ofName(String name) {
        return new Food(Category.mapByName(name), name);
    }

    public Category category() {
        return category;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Food)) {
            return false;
        }
        Food food = (Food) o;
        return category == food.category && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name);
    }
}
