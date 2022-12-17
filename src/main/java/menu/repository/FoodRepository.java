package menu.repository;

import menu.config.InitData;
import menu.domain.Category;
import menu.domain.Food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static menu.domain.Category.*;

public class FoodRepository {
    private static final Map<Category, List<Food>> foods = new HashMap<>();

    static {
        initCategoryData();
        initFoodData();
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
