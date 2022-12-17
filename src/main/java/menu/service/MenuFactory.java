package menu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.cofig.InitMenu;

public class MenuFactory {
    public static List<String> makeCantEatMenus(String[] menus) {
        List<String> cantEatMenus = new ArrayList<>(Arrays.asList(menus));
        if (cantEatMenus.get(0).equals("")) {
            return cantEatMenus;
        }
        validateMenu(cantEatMenus);
        return cantEatMenus;
    }

    private static void validateMenu(List<String> cantEatMenus) {
        for (String menu : cantEatMenus) {
            List<String> menus = InitMenu.menus();
            if (!menus.contains(menu)) {
                throw new IllegalArgumentException(" 존재하지 않는 메뉴입니다.");
            }
        }
        if (cantEatMenus.size() > 2) {
            throw new IllegalArgumentException(" 최소 0개, 최대 2개까지 못 먹는 메뉴를 입력할 수 있습니다.");
        }
    }
}
