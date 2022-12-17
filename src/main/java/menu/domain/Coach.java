package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        for (String food : foods) {
            isAlreadyRecommend(food);
        }
        recommendFood = foods;
    }

    public void isAlreadyRecommend(String food) {
        if (recommendFood.contains(food)) {
            throw new IllegalStateException("[ERROR] 이미 추천음식에 있는 메뉴입니다.");
        }

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
