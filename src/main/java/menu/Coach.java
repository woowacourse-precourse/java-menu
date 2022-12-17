package menu;

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

    public void setRecommendedMenus(List<String> menus) {
        this.menus.addAll(menus);
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
