package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static menu.global.GlobalUnitMessage.*;

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

    public boolean addRecommendedFood(Day day, Food food) {
        boolean foodOk = isFoodOk(food);
        if (foodOk) {
            recommendFoods.put(day, food);
        }
        return foodOk;
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

    @Override
    public String toString() {
        return SQUARE_BRACKET_LEFT.getMessage() +
                recommendFoods.get(Day.MONDAY).loadName() + STICK_SEPARATOR.getMessage() +
                recommendFoods.get(Day.TUESDAY).loadName() + STICK_SEPARATOR.getMessage() +
                recommendFoods.get(Day.WEDNESDAY).loadName() + STICK_SEPARATOR.getMessage() +
                recommendFoods.get(Day.THURSDAY).loadName() + STICK_SEPARATOR.getMessage() +
                recommendFoods.get(Day.FRIDAY).loadName() +
                SQUARE_BRACKET_RIGHT.getMessage();
    }
}
