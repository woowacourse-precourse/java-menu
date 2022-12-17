package menu.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Food;

public class FoodRepository {


    private static final FoodRepository INSTANCE = new FoodRepository();
    private static final List<Food> foodRepository = new ArrayList();

    public static FoodRepository getInstance() {
        return INSTANCE;
    }

    public static void addFood(Food food) {
        foodRepository.add(food);
    }

    public static List<Food> findFoodsByFoodNames(List<String> foodNames) {
        if (!isExistByFoodNames(foodNames)) {
            throw new IllegalArgumentException("[ERROR] 일치하는 음식이 없습니다.");
        }
        return foodRepository.stream()
                .filter(food -> foodNames.contains(food.getFoodName()))
                .collect(Collectors.toList());
    }

    public static boolean isExistByFoodName(String foodName) {
        return foodRepository.stream()
                .anyMatch(food -> foodName.equals(food.getFoodName()));
    }

    public static boolean isExistByFoodNames(List<String> foodNames) {
        return foodNames.stream()
                .allMatch(foodName -> isExistByFoodName(foodName));
    }

    public static void init() {
        Arrays.stream(Category.values())
                .forEach(category -> initFoods(category.getFoodNames()));
    }

    public static void initFoods(List<String> foodNames) {
        foodNames.stream()
                .forEach(foodName -> addFood(new Food(foodName)));
    }

    public static List<Food> findAll() {
        return Collections.unmodifiableList(foodRepository);
    }

}
