package menu.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Food;
import menu.enums.Category;

public class FoodCanNotEatDTO {

    private final List<Food> foodsCanNotEat = new ArrayList<>();
    private static final FoodCanNotEatDTO foodCanNotEatDTO = new FoodCanNotEatDTO();

    public static FoodCanNotEatDTO getInstance() {
        return foodCanNotEatDTO;
    }

    public List<Food> getFoodsCanNotEat() {
        return Collections.unmodifiableList(foodsCanNotEat);
    }

    public void setFoodsCanNotEat(final String nameInput) {
        foodsCanNotEat.clear();
        List<String> names = List.of(nameInput.split(","));
        for (String name : names) {
            Food food = new Food(name);
            Category.from(food);
            foodsCanNotEat.add(food);
        }
    }
}
