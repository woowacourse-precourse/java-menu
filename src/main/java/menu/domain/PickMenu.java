package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utils.Category;
import menu.utils.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickMenu {
    private static final int MAX_CATEGORY_NUMBER = 5;
    private static final int MAX_MENU_NUMBER = 9;
    private static final int MIN_MENU_NUMBER = 1;
    private final List<Menu> menus;

    public PickMenu() {
        menus = new ArrayList<>();
    }

    public void addPickMenu(Category category, List<Menu> notEatableMenu, int weekend) {
        boolean isDuplicate = true;
        boolean isNotEatable = true;
        Menu pickMenu = null;
        while(isDuplicate || isNotEatable) {
            pickMenu = Menu.getRandomFood(category);
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
