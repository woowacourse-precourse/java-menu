package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coach {
    private final String name;
    private final Set<String> hateFood;
    private final List<String> recommendedFood;

    public Coach(String name) { // input view 에서 처리해야지, 조금 더 깔끔하게 처리할 수 있을 듯하다, 안 그러면 Model 측을 view 에서 건드려야함
        this.name = name;
        hateFood = new HashSet<>();
        recommendedFood = new ArrayList<>();
    }

    public void setHateFood(List<String> foods) {
        hateFood.addAll(foods);
    }

    public boolean isHateFood(String food) {
        return hateFood.contains(food); // 있으면 hate food 임
    }

    public boolean isPossibleRecommendFood(String food) {
        return !recommendedFood.contains(food); // true 이면 추천 가능한 것
    }

    public void recommendFood(String food) {
        recommendedFood.add(food);
    }

    public List<String> getRecommendedFoods() {
        return this.recommendedFood;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
