package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendFoods {

    private List<Food> recommendFoods;

    public RecommendFoods() {
        recommendFoods = new ArrayList<>();
    }

    public List<Food> getRecommendFoods() {
        return Collections.unmodifiableList(recommendFoods);
    }

    public void addRecommendFood(Food food) {
        recommendFoods.add(food);
    }

}
