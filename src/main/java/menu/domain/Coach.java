package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> noEatMenu;
    private List<String> recommendedMenu = new ArrayList<>();

    public Coach(String name, List<String> noEatMenu) {
        this.name = name;
        this.noEatMenu = noEatMenu;
    }

    public void addRecommendedMenu(String menu) {
        recommendedMenu.add(menu);
    }

    public boolean canEat(String menu) {
        if (noEatMenu.contains(menu)) {
            return false;
        }
        return true;
    }

    public boolean isRecommended(String menu) {
        if (recommendedMenu.contains(menu)) {
            return true;
        }
        return false;
    }
}
