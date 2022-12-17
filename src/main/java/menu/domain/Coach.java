package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> noEatMenu;
    private List<String> recommendedMenu;

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

    public boolean hasMenu(String menu) {
        return true;
    }
}
