package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static List<Menu> menuList = new ArrayList<>();

    public static void addInitialMenuList() {
        for (MenuList menus : MenuList.values()) {
            menuList.add(new Menu(menus.getCategory(), menus.getMenuList()));
        }
    }

    public static boolean validateMenu(String menuName) {
        for (Menu menu : menuList) {
            if (menu.getMenus().contains(menuName)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getMenuListByCategory(String category) {
        List<String> menuByCategory = new ArrayList<>();
        for (Menu menu : menuList) {
            if (menu.getCategory().equals(category)) {
                menuByCategory = menu.getMenus();
            }
        }
        return menuByCategory;
    }

}
