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

    public PickMenu(PickCategory pickCategory, List<Menu> notEatableMenu) {
        this.menus = pickRandomMenus(pickCategory, notEatableMenu);
    }

    private List<Menu> pickRandomMenus(PickCategory pickCategory, List<Menu> notEatableMenu) {
        boolean isDuplicate = true;
        boolean isNotEatable = true;
        List<Menu> makeMenu = new ArrayList<>();
        while(isDuplicate || isNotEatable) {
            makeMenu.clear();
            for (Category category : pickCategory.getCategories()) {
                makeMenu.add(Menu.getRandomFood(category));
            }
            isDuplicate = validDuplicate(makeMenu);
            isNotEatable = validNotEatable(notEatableMenu, makeMenu);
        }
        return makeMenu;
    }

    private boolean validDuplicate(List<Menu> makeMenu) {
        for (int i = 0 ; i < makeMenu.size(); i++) {
            if (Collections.frequency(makeMenu, makeMenu.get(i)) > 1)
                return true;
        }
        return false;
    }

    private boolean validNotEatable(List<Menu> notEatable, List<Menu> makeMenu) {
        for (Menu menu : notEatable) {
            if (Collections.frequency(makeMenu, menu) >= 1) {
                return true;
            }
        }
        return false;
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }
}
