package menu.domain;

import menu.Utils.Utils;

import java.util.List;

public class Category {
    private final List<Menu> menus;
    private final Style style;
    public Category(List<Menu> menus, int categoryNum) {
        this.menus = menus;
        this.style = Utils.styleToCategoryConverter(categoryNum);
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public Style getStyle() {
        return style;
    }
}
