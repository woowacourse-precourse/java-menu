package menu;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final List<String> menus;

    public Category(String categoryName, String menuNames) {
        this.menus = new ArrayList<>();
        for (String menu : menuNames.split(", "))
            menus.add(menu);
    }

    public List<String> getMenus() {
        return menus;
    }

}
