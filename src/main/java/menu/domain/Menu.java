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

    @Override
    public String toString() {
        return "Menu{" +
                "category=" + category +
                ", name='" + name + '\'' +
                '}';
    }
}
