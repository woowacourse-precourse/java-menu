package menu.domain;

import java.util.List;

public class Blacklist {
    private List<Menu> menus;

    public Blacklist(List<Menu> menus) {
        this.menus = menus;
    }

    public boolean isExist(Menu menu) {
        return menus.contains(menu);
    }
}
