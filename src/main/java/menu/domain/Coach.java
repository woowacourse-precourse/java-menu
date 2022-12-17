package menu.domain;

import java.util.HashSet;
import java.util.Set;

public class Coach {
    private String name;

    private Set<String> cantEatingFoodName;

    public Coach(String name) {
        this.name = name;
        this.cantEatingFoodName = new HashSet<>();
    }

    public void addCantEatingFood(String foodName) {
        cantEatingFoodName.add(foodName);
    }

    public Set<String> getCantEatingFoodName() {
        return cantEatingFoodName;
    }

}
