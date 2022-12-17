package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> notPreferMenu;
    private List<String> recommendedMenus;

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
