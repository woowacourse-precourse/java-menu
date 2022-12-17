package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.constans.Error;

public class Coach {
    private String name;
    private List<String> cantEatFood;
    private List<String> recommendFood;

    public Coach(String name) {
        this.name = name;
        this.cantEatFood = new ArrayList<>();
        this.recommendFood = new ArrayList<>();
    }

    public void addCantEatFood(String foods) {
        String[] split = foods.split(",");
        this.cantEatFood.addAll(Arrays.asList(split));
    }

    public void addRecommendFood(List<String> foods) {
        recommendFood = foods;
    }

    public void isAlreadyRecommend(String food) {
        this.recommendFood.add(food);
    }

    public String getName() {
        return name;
    }

    public List<String> getCantEatFood() {
        return cantEatFood;
    }

    public List<String> getRecommendFood() {
        return recommendFood;
    }
}
