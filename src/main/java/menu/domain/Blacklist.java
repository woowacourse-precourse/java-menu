package menu.domain;

import java.util.List;

public class Blacklist {
    private static final int BLACKLIST_MAX_SIZE = 2;

    private List<Menu> menus;

    public Blacklist(List<Menu> menus) {
        validateBlacklist(menus);
        this.menus = menus;
    }

    public boolean isExist(Menu menu) {
        return menus.contains(menu);
    }

    private void validateBlacklist(List<Menu> blacklist) {
        if (blacklist.size() > BLACKLIST_MAX_SIZE) {
            throw new IllegalArgumentException("못 먹는 메뉴는 2가지까지만 가능합니다");
        }
    }
}
