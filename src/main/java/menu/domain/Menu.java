package menu.domain;

import java.util.Objects;

public class Menu {
    private final Category category;
    private final String name;

    public Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public boolean isNameMatch(String name) {
        return Objects.equals(name, this.name);
    }

    public boolean isCategoryMath(Category category) {
        return this.category == category;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "category=" + category +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
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
