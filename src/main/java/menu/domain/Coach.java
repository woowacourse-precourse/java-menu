package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateMenu;
    private final List<String> recommendMenu;

    public Coach(String name, List<String> hateMenu) {
        this.name = name;
        this.hateMenu = hateMenu;
        this.recommendMenu = new ArrayList<>();
    }

    public boolean addRecommendMenu(String menu) {
        if (recommendMenu.contains(menu) || hateMenu.contains(menu)) {
            return false;
        }
        recommendMenu.add(menu);
        return true;
    }

    public String recommendMenuResult() {
        return "[ " + name + " | " + String.join(" | ", recommendMenu) + " ]";
    }
}
