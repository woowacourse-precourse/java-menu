package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {

    private String name;
    private List<String> dislikeFood;
    private List<Menu> recommendedMenu;

    public Coach(String name) {
        this.name = name;
        this.dislikeFood = new ArrayList<>();
        this.recommendedMenu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getDislikeFood() {
        return dislikeFood;
    }

    public List<Menu> getRecommendedMenu() {
        return recommendedMenu;
    }

    public void addDislikeFood(String foodInput) {
        String[] foods = foodInput.split(",");

        dislikeFood.addAll(Arrays.asList(foods));
    }
}
