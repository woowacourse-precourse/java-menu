package menu.domain;

import menu.utils.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> notEatableMenu;
    private PickMenu pickMenu;

    public Coach(String name) {
        this.name = name;
        this.notEatableMenu = new ArrayList<>();
        pickMenu = new PickMenu();
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

    public List<Menu> getRecommendMenus() {
        return pickMenu.getMenus();
    }

    public PickMenu getPickMenu() {
        return pickMenu;
    }

    public List<Menu> getNotEatableMenu() {
        return Collections.unmodifiableList(notEatableMenu);
    }
}
