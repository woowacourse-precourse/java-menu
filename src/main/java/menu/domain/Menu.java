package menu.domain;

import menu.enums.Category;

public class Menu {
    private final String menu;

    public Menu(Category category, String menu) {
        this.menu = menu;
    }

    public boolean isSameMenu(String menuName) {
        return this.menu.equals(menuName);
    }


    @Override
    public String toString() {
        return menu;
    }
}
