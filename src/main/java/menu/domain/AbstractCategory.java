package menu.domain;

import java.util.List;

public abstract class AbstractCategory {
    public final List<String> menus;

    public AbstractCategory(List<String> menus) {
        this.menus = menus;
    }
}
