package menu.domain;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Coach {

    private static final String COMMA = ",";
    private static final int MINIMUM_LENGTH_OF_NAME = 2;
    private static final int MAXIMUM_LENGTH_OF_NAME = 4;
    private static final int MAXIMUM_LENGTH_OF_CAN_NOT_EAT = 2;

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
        return new ArrayList<>(coaches.keySet());
    }

    public void setCanNotEat(String name, String input) {
        List<String> canNotEatFoods = Arrays.asList(input.split(COMMA));
        validateCanNotEatFood(canNotEatFoods);
        List<String> foods = new ArrayList<>(canNotEatFoods);

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
        String[] names = input.split(COMMA);

        for (String name : names) {
            validateName(name);
            coaches.put(name, new ArrayList<>());
            recommendFoods.put(name, new ArrayList<>());
        }
    }

    private void validateName(String name) {
        if (name.length() < MINIMUM_LENGTH_OF_NAME || name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("[ERROR] 2~4자리의 이름만 입력이 가능합니다.");
        }
    }

    private void validateCanNotEatFood(List<String> canNotEatFoods) {
        if (canNotEatFoods.size() > MAXIMUM_LENGTH_OF_CAN_NOT_EAT) {
            throw new IllegalArgumentException("[ERROR] 각 코치가 먹지 못하는 메뉴는 최소 0개에서 최대 2개입니다.");
        }
    }
}
