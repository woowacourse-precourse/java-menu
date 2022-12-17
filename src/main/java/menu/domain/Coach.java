package menu.domain;

import menu.utils.Menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> notEatableMenu;

    public Coach(String name) {
        this.name = name;
        this.notEatableMenu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addNotEatableMenus(String[] menus) {
        notEatableMenu.clear();
        for (String menu : menus) {
            notEatableMenu.add(Menu.valueOfMenu(menu));
        }
    }
}
