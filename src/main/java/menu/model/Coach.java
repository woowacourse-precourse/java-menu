package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> dislikeMenu;
    private List<String> recommendedMenus = new ArrayList<>();

    public Coach(String name, List<String> dislikeMenu) {
        this.name = name;
        this.dislikeMenu = dislikeMenu;
    }

    public boolean isDuplicateMenu(String recommendedMenu) {
        if (recommendedMenus.contains(recommendedMenu)) {
            return true;
        }
        return false;
    }

    public boolean canEatMenu(String recommendedMenu) {
        if (dislikeMenu.contains(recommendedMenu)) {
            return false;
        }
        return true;
    }
}
