package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> canNotEatMenus;
    private final List<String> recommendedMenu;

    public Coach(String name, List<String> canNotEatMenus) {
        this.name = name;
        this.canNotEatMenus = canNotEatMenus;
        recommendedMenu = new ArrayList<>();
    }

    public boolean canEat(String menu) {
        if (recommendedMenu.contains(menu)) {
            return false;
        }

        if (canNotEatMenus.contains(menu)) {
            return false;
        }

        recommendedMenu.add(menu);
        return true;
    }

    public List<String> requestFormat() {
        List<String> format = new ArrayList<>();
        format.add(name);
        format.addAll(recommendedMenu);
        return format;
    }

}
