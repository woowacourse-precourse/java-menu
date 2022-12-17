package menu.domain.model;

import java.util.Objects;

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

    public boolean isEqualCategory(Category category) {
        return this.category.equals(category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return category == menu.category && Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "category=" + category +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
