package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    String name;
    List<String> cannotEatMenu;
    List<String> alreadyEatMenu;

    public Coach(String name) {
        this.name = name;
        cannotEatMenu = new ArrayList<>();
        alreadyEatMenu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getAlreadyEatMenu() {
        return alreadyEatMenu;
    }

    public void initCannotEatMenu(List<String> cannotEatMenu) {
        this.cannotEatMenu = new ArrayList<>(cannotEatMenu);
    }

    public boolean cannotRecommendMenu(String menu) {
        if (cannotEatMenu.contains(menu)) {
            return true;
        }
        if (alreadyEatMenu.contains(menu)) {
            return true;
        }
        alreadyEatMenu.add(menu);
        return false;
    }
}

