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

    public PickMenu(PickCategory pickCategory) {
        this.menus = pickRandomMenus(pickCategory);
    }

    private List<Menu> pickRandomMenus(PickCategory pickCategory) {
        boolean isDuplicate = true;
        List<Menu> makeMenu = new ArrayList<>();
        while(isDuplicate) {
            makeMenu.clear();
            for (Category category : pickCategory.getCategories()) {
                makeMenu.add(Menu.getRandomFood(category));
            }
            isDuplicate = validDuplicate();
        }
        return makeMenu;
    }

    private boolean validDuplicate() {
        for (int i = 0 ; i < menus.size(); i++) {
            if (Collections.frequency(menus, menus.get(i)) > 1)
                return true;
        }
        return false;
    }
}
