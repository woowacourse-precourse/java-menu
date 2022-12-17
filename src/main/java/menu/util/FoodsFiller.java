package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import menu.domain.Coach;
import menu.domain.menu.*;

public class FoodsFiller {
    public void fillFoods(Coach coach, String category, List<String> bannedFoods) {
        HashMap<String, List<String>> foods = new HashMap<>();
        setupFoods(foods);
        makeFood(coach, category, bannedFoods, foods);
    }

    public void makeFood(Coach coach, String category, List<String> bannedFoods, HashMap<String, List<String>> foods) {
        while (true) {
            String pickFood = getPickFood(category, foods);
            if (!coach.isAlreadyBeenFood(pickFood) && !bannedFoods.contains(pickFood)) {
                coach.addFood(pickFood);
                break;
            }
        }
    }

    public String getPickFood(String category, HashMap<String, List<String>> foods) {
        String foodStyle = FoodStyle.getFoodStyleFromCategoryName(category).getStyle();
        String pickFood = Randoms.shuffle(foods.get(foodStyle)).get(0);
        return pickFood;
    }

    public void setupFoods(HashMap<String, List<String>> foods) {
        foods.put("한식", KoreanFood.any.getAllFoods());
        foods.put("일식", JapaneseFood.any.getAllFoods());
        foods.put("중식", ChineseFood.any.getAllFoods());
        foods.put("양식", ItalianFood.any.getAllFoods());
        foods.put("아시안", AsianFood.any.getAllFoods());
    }
}
