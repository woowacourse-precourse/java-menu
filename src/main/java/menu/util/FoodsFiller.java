package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import menu.domain.Categories;
import menu.domain.Crew;
import menu.domain.Crews;
import menu.domain.menu.AsianFood;
import menu.domain.menu.ChineseFood;
import menu.domain.menu.FoodStyle;
import menu.domain.menu.ItalianFood;
import menu.domain.menu.JapaneseFood;
import menu.domain.menu.KoreanFood;

public class FoodsFiller {
    private final static HashMap<String, List<String>> foods = new HashMap<>();

    public void setupFoods() {
        foods.put("한식", KoreanFood.any.getAllFoods());
        foods.put("일식", JapaneseFood.any.getAllFoods());
        foods.put("중식", ChineseFood.any.getAllFoods());
        foods.put("양식", ItalianFood.any.getAllFoods());
        foods.put("아시안", AsianFood.any.getAllFoods());
    }

    public void fillFoods(Crew crew, Categories categories, List<String> bannedFoods) {
        setupFoods();
        for (String category : categories.getCategories()) {
            makeFood(crew, category, bannedFoods);
        }
    }

    public void makeFood(Crew crew, String category, List<String> bannedFoods) {
        while(true) {
            String pickFood = getPickFood(category);
            if(!crew.isAlreadyBeenFood(pickFood) && !bannedFoods.contains(pickFood)) {
                crew.addFood(pickFood);
                break;
            }
        }
    }

    public String getPickFood(String category) {
        String foodStyle = FoodStyle.getFoodStyleFromCategoryName(category).getStyle();
        String pickFood = Randoms.shuffle(foods.get(foodStyle)).get(0);
        return pickFood;
    }
}
