package menu.domain.menu.entity;

import java.util.Objects;
import menu.domain.menu.Category;

public class Menu {

    private final String name;
    private final Category category;

    public Menu(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public boolean matchesByCategory(Category targetCategory) {
        return this.category.matches(targetCategory);
    }

    public boolean matchesByName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (target == null || getClass() != target.getClass()) {
            return false;
        }
        Menu targetMenu = (Menu) target;
        return Objects.equals(name, targetMenu.name) && category.matches(targetMenu.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}
