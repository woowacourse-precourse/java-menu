package menu.repository;

import menu.config.InitData;
import menu.domain.Category;
import menu.domain.Food;

import java.util.*;
import java.util.stream.Collectors;

import static menu.domain.Category.*;
import static menu.exception.GlobalExceptionMessage.WRONG_FOOD_NAME_EXCEPTION;
import static menu.exception.GlobalExceptionMessage.WRONG_FOOD_NAME_PARSING_EXCEPTION;

public class FoodRepository {
    private static final Map<Category, List<Food>> foods = new HashMap<>();

    static {
        initCategoryData();
        initFoodData();
    }

    public List<String> loadAllFoodNamesByCategory(Category category) {
        return foods.get(category)
                .stream()
                .map(Food::loadName)
                .collect(Collectors.toList());
    }

    public Food findFoodBy(Category category, String lastFoodName) {
        return foods.get(category)
                .stream()
                .filter(food -> food.loadName().equals(lastFoodName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_FOOD_NAME_EXCEPTION.getMessage()));
    }

    public List<Food> findFoodsByNames(List<String> foodNames) {
        if (foodNames.get(0).equals("")) {
            return Collections.emptyList();
        }
        List<Food> findFoods = new ArrayList<>();
        List<List<Food>> categoryFoods = new ArrayList<>(foods.values());
        List<Food> totalFoods = new ArrayList<>();
        categoryFoods.forEach(totalFoods::addAll);
        foodNames.forEach(foodName -> totalFoods.forEach(food -> {
            if (food.isSame(foodName)) {
                findFoods.add(food);
            }
        }));
        validateFoodSize(foodNames, findFoods);
        return findFoods;
    }

    private void validateFoodSize(List<String> foodNames, List<Food> findFoods) {
        if (foodNames.size() != findFoods.size()) {
            throw new IllegalArgumentException(WRONG_FOOD_NAME_PARSING_EXCEPTION.getMessage());
        }
    }

    private static void initCategoryData() {
        InitData.loadCategoryDummy()
                .forEach(category -> foods.put(category, new ArrayList<>()));
    }

    private static void initFoodData() {
        InitData.loadFoodDummy().forEach(food -> {
            addJapaneseFood(food);
            addKoreanFood(food);
            addChineseFood(food);
            addAsianFood(food);
            addWesternFood(food);
        });
    }

    private static void addWesternFood(Food food) {
        if (food.isWesternFood()) {
            foods.get(WESTERN_FOOD_CATEGORY).add(food);
        }
    }

    private static void addAsianFood(Food food) {
        if (food.isAsianFood()) {
            foods.get(ASIAN_FOOD_CATEGORY).add(food);
        }
    }

    private static void addChineseFood(Food food) {
        if (food.isChineseFood()) {
            foods.get(CHINESE_FOOD_CATEGORY).add(food);
        }
    }

    private static void addKoreanFood(Food food) {
        if (food.isKoreanFood()) {
            foods.get(KOREAN_FOOD_CATEGORY).add(food);
        }
    }

    private static void addJapaneseFood(Food food) {
        if (food.isJapaneseFood()) {
            foods.get(JAPANESE_FOOD_CATEGORY).add(food);
        }
    }
}
