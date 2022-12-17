package domain;

import java.util.List;

public class DayCategoryMenu {
    private final Category category;
    private final List<Menu> menusName;

    public DayCategoryMenu(Category category, List<Menu> menusName) {
        this.category = category;
        this.menusName = menusName;
    }

    public Category getCategory() {
        return category;
    }

    public List<Menu> getMenusName() {
        return menusName;
    }
}
