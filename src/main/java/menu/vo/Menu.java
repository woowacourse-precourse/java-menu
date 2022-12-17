package menu.vo;

import menu.enums.FoodCategory;

import java.util.List;

public class Menu {
    private final FoodCategory foodCategory;
    private final List<String> foods;

    public Menu(FoodCategory foodCategory, List<String> foods) {
        this.foodCategory = foodCategory;
        this.foods = foods;
    }
}
