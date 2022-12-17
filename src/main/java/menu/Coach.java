package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {
    private String name;
    private List<String> unwantedMenus = new ArrayList<>();
    private List<String> menus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void setUnwantedMenus(String menus) {
        unwantedMenus = Arrays.asList(menus.split(","));
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

}
