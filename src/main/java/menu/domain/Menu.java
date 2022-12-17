package menu.domain;

import menu.domain.enums.Category;

import java.util.Objects;

public class Menu {

    private final Category category;
    private final String name;

    public Menu(final Category category, final String name) {
        this.category = category;
        this.name = name;
    }

    public static Menu ofName(final String name) {
        return new Menu(Category.mapByName(name), name);
    }

    public Category category() {
        return category;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Menu)) {
            return false;
        }
        Menu menu = (Menu) o;
        return category == menu.category && Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name);
    }
}
