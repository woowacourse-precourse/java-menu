package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {

    private final Category category;
    private final String name;

    public Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public static List<Menu> convertToMenus(Category category, String menuNames) {
        List<Menu> menus = new ArrayList<>();
        for (String menuName : menuNames.split(", ")) {
            menus.add(new Menu(category, menuName));
        }
        return menus;
    }

    public boolean checkMenuName(String menuName) {
        return this.name.equals(menuName);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Menu)) {
            return false;
        }
        Menu that = (Menu) o;
        return name == that.name;
    }
}
