package menu.domain.menu;

import java.util.Objects;

public class Menu {
    private final String name;
    private final MenuCategory menuCategory;

    private Menu(String name, MenuCategory menuCategory) {
        this.name = name;
        this.menuCategory = menuCategory;
    }

    public static Menu of(String name, MenuCategory menuCategory) {
        return new Menu(name, menuCategory);
    }

    public String getName() {
        return name;
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
        return Objects.equals(name, menu.name) && menuCategory == menu.menuCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, menuCategory);
    }
}
