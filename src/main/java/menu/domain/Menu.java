package menu.domain;

import java.util.Objects;

public class Menu {

    private final String menuName;
    private final Category category;

    public Menu(String menuName, Category category) {
        this.menuName = menuName;
        this.category = category;
    }

    public boolean isSameName(String menuName) {
        return menuName.equals(this.menuName);
    }

    public boolean isSameCategory(Category category) {
        return this.category.equals(category);
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Menu menu = (Menu) o;
        return Objects.equals(menuName, menu.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName);
    }
}
