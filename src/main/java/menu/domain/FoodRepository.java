package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {
    private static List<Food> foods = new ArrayList<>();
    public static List<Food> getFoods() {
        return foods;
    }

    public static void addFood(Food food) {
        foods.add(food);
    }
}
