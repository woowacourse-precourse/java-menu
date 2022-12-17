package menu.domain;

import java.util.List;

public class Coach {

    private final String name;
    private final RecommendFoods recommendFoods;

    public Coach(String name) {
        this.name = name;
        this.recommendFoods = new RecommendFoods();
    }

    public String getName() {
        return this.name;
    }

    public List<Food> getRecommendFoods() {
        return recommendFoods.getRecommendFoods();
    }

    public void addRecommendFood(Food food) {
        recommendFoods.addRecommendFood(food);
    }

}
