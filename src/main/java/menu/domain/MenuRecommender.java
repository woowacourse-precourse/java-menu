package menu.domain;

import java.util.Map;

public class MenuRecommender {

    Map<Category, Menus> menus;

    public MenuRecommender(Map<Category, Menus> menus) {
        this.menus = menus;
    }
}
