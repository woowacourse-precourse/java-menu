package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodRepository {
    private static final List<Food> foods = new ArrayList<>();

    public static List<Food> foods() {
        return Collections.unmodifiableList(foods);
    }

    public static void addFood(Food food) {
        foods.add(food);
    }

    public static void deleteAll() {
        foods.clear();
    }

    public static Food getFoodByName(String name) {
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }

    public static boolean contains(String name) {
        return foods.contains(getFoodByName(name));
    }
}
