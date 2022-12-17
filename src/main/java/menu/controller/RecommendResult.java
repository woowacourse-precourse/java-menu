package menu.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.FoodCategory;
import menu.domain.Menu;

public class RecommendResult {

    private final List<FoodCategory> foodCategories;
    private final Map<Coach, List<Menu>> coachFoods;

    public RecommendResult(List<FoodCategory> foodCategories, Map<Coach, List<Menu>> coachFoods) {
        this.foodCategories = foodCategories;
        this.coachFoods = coachFoods;
    }

    public List<String> getDays() {
        return Arrays.stream(Day.values())
            .map(Day::getName)
            .collect(Collectors.toList());
    }

    public List<String> getCategories() {
        return foodCategories.stream()
            .map(FoodCategory::getName)
            .collect(Collectors.toList());
    }

    public Map<String, List<String>> getEatFoods() {
        Map<String, List<String>> result = new HashMap<>();
        coachFoods.keySet()
            .forEach(k ->
                result.put(k.getName(), coachFoods.get(k).stream()
                    .map(Menu::getName)
                    .collect(Collectors.toList())));
        return result;
    }
}
