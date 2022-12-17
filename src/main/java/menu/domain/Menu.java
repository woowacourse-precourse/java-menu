package menu.domain;

import java.util.Objects;

public class Menu {
    private final String name;

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return name.equals(menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
