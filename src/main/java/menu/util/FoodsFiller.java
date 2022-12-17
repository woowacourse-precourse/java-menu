package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import menu.domain.Crew;
import menu.domain.menu.AsianFood;
import menu.domain.menu.ChineseFood;
import menu.domain.menu.FoodStyle;
import menu.domain.menu.ItalianFood;
import menu.domain.menu.JapaneseFood;
import menu.domain.menu.KoreanFood;

public class FoodsFiller {
    public void fillFoods(Crew crew, String category, List<String> bannedFoods) {
        HashMap<String, List<String>> foods = new HashMap<>();
        setupFoods(foods);
        makeFood(crew, category, bannedFoods, foods);
    }

    public void makeFood(Crew crew, String category, List<String> bannedFoods, HashMap<String, List<String>> foods) {
        while (true) {
            String pickFood = getPickFood(category, foods);
            if (!crew.isAlreadyBeenFood(pickFood) && !bannedFoods.contains(pickFood)) {
                crew.addFood(pickFood);
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
