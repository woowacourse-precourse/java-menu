package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {
    private static List<Food> foods = new ArrayList<>();
    public static List<Food> getFoods() {
        return foods;
    }

    public static List<String> getFoodNamesByCategory(FoodCategory foodCategory) {
        List<String> categorizedFoods = new ArrayList<>();
        for (Food food : foods) {
            if (food.getFoodCategory() == foodCategory) {
                categorizedFoods.add(food.getName());
            }
        }
        return categorizedFoods;
    }

    public static void addFood(Food food) {
        foods.add(food);
    }

    public static boolean isExistingFood(String name) {
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Food getFoodByName(String name) {
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }
}
