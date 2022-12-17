package menu.domain;

import java.util.List;

public class Category {
    String name;
    List<String> foods;

    public Category(String name, List<String> foods) {
        this.name = name;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public List<String> getFoods() {
        return foods;
    }

    public boolean isExistFood(String foodName) {
        for (String food : foods) {
            if (food.equals(foodName)) {
                return true;
            }
        }

        return false;
    }
}
