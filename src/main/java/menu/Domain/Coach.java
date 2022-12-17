package menu.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Coach {
    private String name;
    private List<String> menus = new ArrayList<>();

    private List<String> unfavorMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addUnfavoredMenus(List<String> menuList) {
        for (String menu : menuList) {
            unfavorMenus.add(menu);
        }
    }

    public boolean hasSameMenu() {
        if (Set.copyOf(menus).size() != menus.size()) {
            return true;
        }
        return false;
    }

    public boolean hasUnfavoredMenu() {
        for (String unfavoredMenu : unfavorMenus) {
            if (menus.contains(unfavoredMenu)) {
                return true;
            }
        }
        return false;
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public void clearMenu() {
        menus.clear();
    }

    public List<String> getMenus() {
        return menus;
    }

}
