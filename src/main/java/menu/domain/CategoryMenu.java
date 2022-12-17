package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryMenu {
    private static List<List<String>> categoryMenu = new ArrayList<>();

    public static List<List<String>> categoryMenu() {
        return categoryMenu;
    }

    public static void setCategoryMenu(List<String> MenuList) {
        categoryMenu.add(MenuList);
    }

    public static void removeMenu(String menuName) {
        for (List<String> category : categoryMenu) {
            category.remove(menuName);
        }
    }
}
