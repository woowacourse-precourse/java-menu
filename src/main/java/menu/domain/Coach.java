package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> inedibleFoods;
    private List<String> recommendedFoods;


    public Coach(String name) {
        this.name = name;
        this.inedibleFoods = new ArrayList<>();
        this.recommendedFoods = new ArrayList<>();
    }

    public void addInedibleFood(String[] foodNames) {
        for (String foodName : foodNames) {
            inedibleFoods.add(foodName);
        }
    }

    public void addRecommendedFood(String foodName) {
        recommendedFoods.add(foodName);
    }

    public String getName() {
        return name;
    }

    public List<String> getInedibleFoods() {
        return inedibleFoods;
    }

    public List<String> getRecommendedFoods() {
        return recommendedFoods;
    }

    public boolean containsInedibleFood(String foodName) {
        return inedibleFoods.contains(foodName);
    }

    public boolean containsRecommendedFood(String foodName) {
        return recommendedFoods.contains(foodName);
    }
}
