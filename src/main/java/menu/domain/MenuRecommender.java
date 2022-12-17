package menu.domain;

import java.util.Map;

public class MenuRecommender {

    private final Map<Category, Menus> menus;

    public MenuRecommender(Map<Category, Menus> menus) {
        this.menus = menus;
    }

    public boolean isExistedMenu(String menu) {
        for (Menus menus : this.menus.values()) {
            if (menus.isExistedMenu(menu)) {
                return true;
            }
        }
        return false;
    }
}
