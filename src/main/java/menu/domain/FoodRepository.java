package menu.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FoodRepository {

    private final List<Food> foods;

    public FoodRepository(final List<Food> foods) {
        this.foods = foods;
    }

    public List<Food> foods() {
        return Collections.unmodifiableList(foods);
    }

    public void add(final Food food) {
        foods.add(food);
    }

    public boolean deleteLineByName(final String name) {
        return foods.removeIf(food -> Objects.equals(food.getName(), name));
    }

    public int size() {
        return foods.size();
    }

    public boolean contains(final Food food) {
        return foods.contains(food);
    }

    public boolean contains(final String otherFood) {
        return foods.stream().anyMatch(food -> food.getName().equals(otherFood));
    }


    public void deleteAll() {
        foods.clear();
    }
}
