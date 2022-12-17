package menu.domain;

import java.util.List;
import java.util.Objects;

public class Menu {
    private final Category category;
    private final List<String> menuNames;

    public Menu(Category category, List<String> menuNames) {
        this.category = category;
        this.menuNames = menuNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return category == menu.category && Objects.equals(menuNames, menu.menuNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, menuNames);
    }
}
