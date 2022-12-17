package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> unwantedMenus = new ArrayList<>();
    private List<String> menus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void setUnwantedMenus(List<String> menus) {
        unwantedMenus.addAll(menus);
    }

    public void addRecommendedMenus(String menus) {
        this.menus.add(menus);
    }

    public boolean availableMenu(String menu){
        return !hasMenu(menu) && !isUnwantedMenu(menu);
    }

    public boolean hasMenu(String menu){
        return menus.contains(menu);
    }

    public boolean isUnwantedMenu(String menu) {
        return unwantedMenus.contains(menu);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String str = "[ " + name + " | ";
        for (int i = 0; i < menus.size(); i++) {
            str += menus.get(i);
            if (i != menus.size() - 1)
                str += " | ";
        }
        str += " ]";

        return str;
    }

}
