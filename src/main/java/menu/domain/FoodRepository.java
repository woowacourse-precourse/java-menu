package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FoodRepository {

    private final List<Food> foods;

    public FoodRepository(List<Food> foods) {
        this.foods = foods;
    }

    public List<Food> foods() {
        return Collections.unmodifiableList(foods);
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public boolean deleteLineByName(String name) {
        return foods.removeIf(food -> Objects.equals(food.getName(), name));
    }

    public boolean contains(Food food) {
        return foods.contains(food);
    }

    public void deleteAll() {
        foods.clear();
    }
}
