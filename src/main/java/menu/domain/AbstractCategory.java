package menu.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCategory {
    public List<String> menus;

    public AbstractCategory(List<String> menus) {
        this.menus = menus;
    }
}
