package menu.domain;

import java.util.Collections;
import java.util.List;

public class Category {
    private String name;
    private List<String> foods;

    public Category(String name, List<String> foods) {
        this.name = name;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public List<String> getFoods() {
        return Collections.unmodifiableList(foods);
    }

    public Boolean findByName(String name) {
        int result = (int) foods.stream()
                .filter(food -> food.equals(name))
                .count();

        if (result != 0) {
            return true;
        }

        return false;
    }
}

