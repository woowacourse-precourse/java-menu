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
}
