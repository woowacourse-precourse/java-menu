package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
    private String name;
    private List<String> foods;

    public Category(String name) {
        this.name = name;
        foods = new ArrayList<>();
    }

    public void addFood(String food) {
        foods.add(food);
    }

    public boolean hasFood(String foodName) {
        return foods.stream().anyMatch(foodName::equals);
    }

    public String getName() {
        return name;
    }

    public List<String> getAllFoods() {
        return Collections.unmodifiableList(foods);
    }
}
