package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {
    private final String name;
    private final List<Food> hateFoods = new ArrayList<>();
    private final Map<Day, Food> recommendFoods = new HashMap<>();

    public Coach(String name) {
        this.name = name;
    }

    public String loadName() {
        return this.name;
    }

    public void addCoachHateFoods(List<Food> findFoods) {
        if (!findFoods.isEmpty()) {
            hateFoods.addAll(findFoods);
        }
    }

    public void addRecommendedFood(Day day, Food food) {
        recommendFoods.put(day, food);
    }

    public void clearHateFood() {
        hateFoods.clear();
    }

    public boolean isFoodOk(Food food) {
        if (isHateFood(food)) {
            return false;
        }
        if (isDuplicatedFood(food)) {
            return false;
        }
        if (isDuplicatedCategory(food)) {
            return false;
        }
        return true;
    }

    public List<Food> loadRecommendFoods() {
        return new ArrayList<>(recommendFoods.values());
    }

    private boolean isHateFood(Food food) {
        return hateFoods.contains(food);
    }

    private boolean isDuplicatedFood(Food food) {
        return recommendFoods.containsValue(food);
    }

    private boolean isDuplicatedCategory(Food food) {
        int count = (int) recommendFoods.values()
                .stream()
                .filter(recommendedFood -> recommendedFood.isSameCategory(food))
                .count();
        return count >= 3;
    }
}
