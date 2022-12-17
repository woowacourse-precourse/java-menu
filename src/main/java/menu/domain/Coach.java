package menu.domain;

import menu.constant.Day;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Coach {
    private String name;
    private List<String> inedibleFoods;
    private Map<Day, String> recommendation;

    public Coach(String name) {
        this.name = name;
        inedibleFoods = new ArrayList<>();
        recommendation = new HashMap<>();
    }

    public void addInedibleFood(String foodName) {
        inedibleFoods.add(foodName);
    }

    public void addRecommendation(Day day, String food) {
        recommendation.put(day, food);
    }

    public boolean isEdible(String foodName) {
        return inedibleFoods.stream().noneMatch(foodName::equals);
    }

    public boolean isRecommended(String foodName) {
        return recommendation.values().stream().anyMatch(foodName::equals);
    }

    public List<String> findRecommendations() {
        List<String> recommendations = new ArrayList<>();
        recommendations.add(name);
        recommendations.addAll(findRecommendationFoodInOrder());
        return recommendations;
    }

    private List<String> findRecommendationFoodInOrder() {
        return Arrays.stream(Day.values())
                .map(day -> recommendation.get(day))
                .collect(Collectors.toUnmodifiableList());
    }

    // TODO: 코치 이름 2글자에서 4글자 검증 기능 구현하기

    public String getName() {
        return name;
    }
}
