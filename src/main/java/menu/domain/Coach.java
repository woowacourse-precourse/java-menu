package menu.domain;

import menu.utils.Menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> notEatableMenu;
    private PickMenu pickMenu;

    public Coach(String name) {
        this.name = name;
        this.notEatableMenu = new ArrayList<>();
        pickMenu = null;
    }

    public String getName() {
        return name;
    }

    public void addNotEatableMenus(String[] menus) {
        notEatableMenu.clear();
        for (String menu : menus) {
            if(!menu.trim().isBlank()) {
                notEatableMenu.add(Menu.valueOfMenu(menu));
            }
        }
    }

    public void makePickMenu(PickCategory pickCategory) {
        pickMenu = new PickMenu(pickCategory, notEatableMenu);
    }

    public List<Menu> getPickMenu() {
        return pickMenu.getMenus();
    }
}
