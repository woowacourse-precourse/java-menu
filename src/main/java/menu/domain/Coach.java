package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final List<Menu> menus;
    private List<String> bannedMenus;

    private final String name;

    public Coach(String name) {
        this.menus = new ArrayList<>();
        this.name = name;
    }

    public void postBannedMenus(List<String> bannedMenus) {
        this.bannedMenus = bannedMenus;
    }

    public String getName() {
        return name;
    }

    public boolean isBannedMenu(String name) {
        return menus.contains(name);
    }
}
