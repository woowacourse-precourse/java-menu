package menu.utils;

import java.util.ArrayList;
import java.util.List;

public class FoodsInputParser {
    private static final String DELIMITER = ",";

    private static void validateFood(String food) {
        if (food.isBlank()) {
            throw new IllegalArgumentException("음식의 이름은 공백일 수 없습니다.");
        }
    }

    private static void validateFoods(List<String> foods) {
        int foodCount = foods.size();
        if (foodCount > 2) {
            throw new IllegalArgumentException("음식은 최대 2개까지 입력이 가능합니다.");
        }
    }

    public static List<String> parser(String input) {
        List<String> foods = new ArrayList<>();
        if (input.isBlank()) {
            return foods;
        }
        for (String food : input.split(DELIMITER)) {
            validateFood(food);
            foods.add(food);
        }
        validateFoods(foods);

        return foods;
    }
}
