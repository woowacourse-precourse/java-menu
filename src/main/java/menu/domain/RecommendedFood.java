package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.FoodRecommender;

public class RecommendedFood {
    private List<String> foods;

    public RecommendedFood() {
        this.foods = new ArrayList<>();
    }

    //한 요일에 대해서 업데이트
    public void pickRecommendedFood(List<String> foodsInCategory, List<String> dislikeFoods) {
        String food;
        while (true) {
            food = FoodRecommender.pickRandomFood(foodsInCategory);
            if (isAbleToAdd(food, dislikeFoods)) {
                continue;
            }
            foods.add(food);
            break;
        }
    }

    public List<String> getFoods() {
        return Collections.unmodifiableList(foods);
    }

    private boolean isAbleToAdd(String food, List<String> dislikeFoods) {
       return foods.contains(food) || dislikeFoods.contains(food);
    }
}
