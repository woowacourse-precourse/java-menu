package menu.util;

import menu.type.CategoryList;

import java.util.ArrayList;
import java.util.List;

public class TotalMenuInfo {

    public static List<String> getTotalMenus() {
        List<String> menus = new ArrayList<>();
        menus.addAll(CategoryList.일식.getMenus());
        menus.addAll(CategoryList.한식.getMenus());
        menus.addAll(CategoryList.중식.getMenus());
        menus.addAll(CategoryList.아시안.getMenus());
        menus.addAll(CategoryList.양식.getMenus());
        return menus;
    }
}
