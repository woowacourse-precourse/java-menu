package menu.domain;

import menu.utils.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickMenu {
    private final List<Menu> menus;

    public PickMenu() {
        menus = new ArrayList<>();
    }

    public void addPickMenu(PickCategory category, List<Menu> notEatableMenu, int weekend) {
        boolean isDuplicate = true;
        boolean isNotEatable = true;
        Menu pickMenu = null;
        while(isDuplicate || isNotEatable) {
            pickMenu = Menu.getRandomFood(category.getCategories().get(weekend));
            isDuplicate = validDuplicate();
            isNotEatable = validNotEatable(notEatableMenu);
        }
        menus.add(pickMenu);
    }

    private boolean validDuplicate() {
        for (int i = 0 ; i < menus.size(); i++) {
            if (Collections.frequency(menus, menus.get(i)) > 1)
                return true;
        }
        return false;
    }

    private boolean validNotEatable(List<Menu> notEatable) {
        for (Menu menu : notEatable) {
            if (Collections.frequency(menus, menu) >= 1) {
                return true;
            }
        }
        return false;
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }
}
