package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.CategoryMenu;

public class CategorySelector {
    private final int MIN_CATEGORY_NUMBER = 1;
    private final int MAX_CATEGORY_NUMBER = 5;

    private final int PICK_MENU_NUMBER = 0;

    public CategoryMenu pickCategory() {
        return CategoryMenu.getCategory(Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER, MAX_CATEGORY_NUMBER));
    }

    public String pickMenu(CategoryMenu categoryMenu) {
        return Randoms.shuffle(CategoryMenu.getMenus(categoryMenu)).get(PICK_MENU_NUMBER);
    }
}
