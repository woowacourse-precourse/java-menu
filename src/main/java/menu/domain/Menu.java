package menu.domain;

import java.util.Objects;

public class Menu {

    private final Category category;
    private final String name;

    public Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        Menu target = (Menu) obj;
        if(this.category == target.category && this.name == target.name) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name);
    }
}
