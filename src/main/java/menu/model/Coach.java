package menu.model;

import java.util.List;

public class Coach {
    private String name;
    private List<String> dislikeMenu;

    public Coach(String name, List<String> dislikeMenu) {
        this.name = name;
        this.dislikeMenu = dislikeMenu;
    }

    public boolean canEatMenu (String recommendedMenu) {
        if (dislikeMenu.contains(recommendedMenu)) {
            return false;
        }
        return true;
    }
}
