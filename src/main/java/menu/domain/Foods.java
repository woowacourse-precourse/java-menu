package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Foods {

    private final List<Food> foods;

    public Foods() {
        this.foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public boolean canEat(Food food) {
        return !foods.contains(food);
    }

}
