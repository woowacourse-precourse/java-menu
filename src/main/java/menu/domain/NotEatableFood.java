package menu.domain;

import menu.domain.enumeration.Food;

import java.util.ArrayList;
import java.util.List;

public class NotEatableFood {

    private static final String INVAILD_FOOD_NAME = "메뉴에 없는 음식입니다. 정확한 음식 이름을 입력해 주세요";

    private final List<String> notEatableFoods;

    public static NotEatableFood createNotEatableFood(String notEatableFoodInput){
        return new NotEatableFood(notEatableFoodInput);
    }

    private NotEatableFood(String notEatableFood){
        List<String> notEatableFoods =  List.of(notEatableFood.split(","));
        valudateNotEatableFoods(notEatableFoods);
        this.notEatableFoods = notEatableFoods;
    }

    public void valudateNotEatableFoods(List<String> notEatableFoods) {
        for (String notEatableFood : notEatableFoods) {
            checkFoodName(notEatableFood);
        }
    }

    private void checkFoodName(String notEatableFood) {
        Food[] foodName = Food.getAllFood();
        List<String> foodNames = new ArrayList<String>();
        for (Food food : foodName) {
            foodNames.add(food.getFoodName());
        }
        if (!foodNames.contains(notEatableFood)) {
            throw new IllegalArgumentException(INVAILD_FOOD_NAME);
        }
    }
}
