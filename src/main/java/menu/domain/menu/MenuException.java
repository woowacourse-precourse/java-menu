package menu.domain.menu;

import menu.domain.menu.Menu;
import menu.util.ExceptionMsg;

import java.util.List;

public class MenuException {
    public static void checkMenuList(Menu menu, List<String> foods) {
        int count = 0;
        for (List<String> menuList : menu.getMenus().values()) {
            count += checkNotInMenu(menuList, foods);
        }
        notInMenuException(count, foods.size());
    }

    private static int checkNotInMenu(List<String> menuList, List<String> foods) {
        int count = 0;
        for (String food : foods) {
            if (isInMenu(menuList, food)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isInMenu(List<String> menuList, String food) {
        if (menuList.contains(food)) {
            return true;
        }
        return false;
    }

    private static void notInMenuException(int count, int foodsSize) {
        if (count != foodsSize) {
            throw new IllegalArgumentException(ExceptionMsg.NOT_MENU.getMsg());
        }
    }
}
