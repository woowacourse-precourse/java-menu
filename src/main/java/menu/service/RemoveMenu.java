package menu.service;

import java.util.List;

public class RemoveMenu {

    public static List<List<String>> removeMenu(List<String> menuList) {
        List<List<String>> menu = Init.initiateMenu();

        for (String menuName : menuList) {
            menu.remove(menuName);
//        for (List<String> menuBycategory : menu)
        }
//        {
//            for (String menuName : menuList) {
//                if (menuBycategory.contains(menuName)) {
//                    menuBycategory.remove(menu);
//                }
//            }
//        }

        return menu;
    }

}
