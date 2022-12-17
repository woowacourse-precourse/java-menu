package menu.Model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> notPreferMenu;
    private final List<String> recommendedMenus;

    public Coach(String name) {
        this.name = name;
        this.notPreferMenu = new ArrayList<>();
        this.recommendedMenus = new ArrayList<>();
    }

    public void addNotPreferMenu(String food) {
        notPreferMenu.add(food);
    }

    public String getName() {
        return name;
    }

    public List<String> getNotPreferMenu() {
        return notPreferMenu;
    }

    public void addRecommendedMenus(String input) {
        recommendedMenus.add(input);
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }
}
