package menu;

import menu.domain.InitialMenu;

public class CategoryPicker {
    private CategoryPicker() {
    }

    public static String pickCategory() {
        return InitialMenu.pickCategory(RandomNumberGenerator.getMenuNumber());
    }
}
