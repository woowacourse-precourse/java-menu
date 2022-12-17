package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private DislikeFoods dislikeFoods;
    private List<String> recommendedMenus;

    public Coach(String name) {
        this.name = name;
        this.dislikeFoods = new DislikeFoods();
        this.recommendedMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getDislikeFoods() {
        return dislikeFoods.getDislikeFoods();
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public void addDislikeFood(String foodInput) {
        dislikeFoods.addDislikeFood(foodInput);
    }

    public void addRecommendedMenu(String menu) {
        recommendedMenus.add(menu);
    }
}
