package menu.domain.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    public Map<String, List<String>> menus;

    public Menu() {
        menus = new HashMap<>();
    }

    public void addMenu(String name, List<String> menuList) {
        menus.put(name, menuList);
    }

    public Map<String, List<String>> getMenus() {
        return menus;
    }
}
