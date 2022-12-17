package menu.domain;

import java.util.List;
import menu.domain.enums.Menu;

public class ExcludeMenu {
    private final List<Menu> menus;

    public ExcludeMenu(final List<Menu> menus) {
        this.menus = menus;
    }
}
