package menu.domain;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Coach {

    private final Map<String, List<String>> coaches;
    private final Map<String, List<String>> recommendFoods;

    public Coach(String input) {
        this.coaches = new LinkedHashMap<>();
        this.recommendFoods = new LinkedHashMap<>();
        makeCoach(input);
    }

    public List<String> getCanNotEatFoods(String name) {
        return coaches.get(name);
    }

    public List<String> getRecommendFoods(String name) {
        return recommendFoods.get(name);
    }

    public List<String> getNames() {
        List<String> coachNames = new ArrayList<>();
        coachNames.addAll(coaches.keySet());

        return coachNames;
    }

    public void setCanNotEat(String name, String input) {
        List<String> foods = new ArrayList<>();

        String[] words = input.split(",");
        foods.addAll(Arrays.asList(words));

        coaches.put(name, foods);
    }

    public void setRecommendFoods(String name, String food) {
        recommendFoods.get(name).add(food);
    }

    @Override
    public String toString() {
        String totalRecommend = "";

        for (String name : recommendFoods.keySet()) {
            totalRecommend += "[ " + name;
            for (String food : recommendFoods.get(name)) {
                totalRecommend += " | " + food;
            }
            totalRecommend += " ]\n";
        }

        return totalRecommend;
    }

    private void makeCoach(String input) {
        String[] names = input.split(",");

        for (String name : names) {
            validateName(name);
            coaches.put(name, new ArrayList<>());
            recommendFoods.put(name, new ArrayList<>());
        }
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 2~4자리의 이름만 입력이 가능합니다.");
        }
    }
}
