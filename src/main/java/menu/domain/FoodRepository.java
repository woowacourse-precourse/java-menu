package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodRepository {

    public static final List<Food> foods = new ArrayList<>();

    public static void addFood(Food food) {
        foods.add(food);
    }

    public static List<Food> getFoods() {
        return Collections.unmodifiableList(foods);
    }
}
