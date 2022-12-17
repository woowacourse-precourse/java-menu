package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Food;

public class FoodRepository {

    private static final String INVALID_FOOD_NAME_MESSAGE = "해당 음식이 없습니다. 올바른 음식 이름을 입력해주세요.";

    public static final List<Food> foods = new ArrayList<>();

    public static void addFood(Food food) {
        foods.add(food);
    }

    public static List<Food> getFoods() {
        return Collections.unmodifiableList(foods);
    }

    public static Food getByName(String name) {
        return foods.stream()
                .filter(food -> food.hasSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_FOOD_NAME_MESSAGE));
    }

    public static List<String> getAllFoodsByCategory(Category category) {
        return foods.stream()
                .filter(food -> food.hasSameCategory(category))
                .map(Food::getName)
                .collect(Collectors.toList());
    }
}
