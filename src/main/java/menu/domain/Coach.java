package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private DislikeFood dislikeFood;
    private List<String> recommendedMenus;

    public Coach(String name) {
        this.name = name;
        this.dislikeFood = new DislikeFood();
        this.recommendedMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getDislikeFood() {
        return dislikeFood.getDislikeFood();
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public void addDislikeFood(String foodInput) {
        dislikeFood.addDislikeFood(foodInput);
    }

    public void addRecommendedMenu(String menu) {
        recommendedMenus.add(menu);
    }
}
