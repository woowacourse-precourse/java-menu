package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> dislikeMenu;
    private List<String> recommendedMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void registerDislikeMenu(List<String> dislikeMenu) {
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

    public void setRecommendedMenu(String menu) {
        recommendedMenus.add(menu);
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }
}
