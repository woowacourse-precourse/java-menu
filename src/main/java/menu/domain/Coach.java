package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> deniedMenus;
    private final List<String> recommendedMenus;

    public Coach(String name, List<String> deniedMenus) {
        this.name = name;
        this.deniedMenus = deniedMenus;
        recommendedMenus = new ArrayList<>();
    }

    public boolean canEat(String menu) {
        if (recommendedMenus.contains(menu)) {
            return false;
        }

        if (deniedMenus.contains(menu)) {
            return false;
        }

        recommendedMenus.add(menu);
        return true;
    }

    public List<String> getRecommendMenuFormat() {
        List<String> format = new ArrayList<>();
        format.add(name);
        format.addAll(recommendedMenus);
        return format;
    }

}
