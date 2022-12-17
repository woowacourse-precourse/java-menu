package menu.domain;

import java.util.HashSet;
import java.util.Set;

public class Coach {
    private String name;
    private Set<Food> inedibleFoods = new HashSet<>();

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
}
