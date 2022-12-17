package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuSelector {

    public static final int FIRST_INDEX = 0;
    public static final int CATEGORY_MIN_INDEX = 1;
    public static final int CATEGORY_MAX_INDEX = 5;

    public static Category getCategory() {
        int index = Randoms.pickNumberInRange(CATEGORY_MIN_INDEX, CATEGORY_MAX_INDEX);
        return Category.getCategory(index);
    }

    public static Menu getMenu(Category category) {
        List<String> shuffledMenu = Randoms.shuffle(category.getMenus());
        return new Menu(shuffledMenu.get(FIRST_INDEX));
    }
}
