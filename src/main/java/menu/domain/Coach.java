package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coach {
    private String name;
    private Set<Food> inedibleFoods = new HashSet<>();
    private List<Food> recommendedFoods = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public boolean addInedibleFood(Food food) {
        return inedibleFoods.add(food);
    }

    public String getName() {
        return name;
    }

    public void SetInedibleFoods(String inedibleFoodInputs) {
        for (String inedibleFoodInput : inedibleFoodInputs.split(",")) {
            inedibleFoods.add(FoodRepository.getFoodByName(inedibleFoodInput));
        }
    }

    public void addRecommendedFood(Food food) {
        recommendedFoods.add(food);
    }

    public boolean isInedibleFood(Food food) {
        return inedibleFoods.contains(food);
    }

    public boolean isAlreadyRecommended(Food food) {
        return recommendedFoods.contains(food);
    }

    public List<Food> getRecommendedFoods() {
        return recommendedFoods;
    }
}
