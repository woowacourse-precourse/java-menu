package menu.domain.menu;

import menu.domain.FoodCategory;

import java.util.List;

public class JapaneseMenu {

    public FoodCategory foodCategory;
    public List<String> japaneseFoods;

    public JapaneseMenu() {
        this.foodCategory = FoodCategory.JAPANESE;
        this.japaneseFoods = List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
    }

    public boolean isContain(String foodName) {
        if (japaneseFoods.contains(foodName)) {
            return true;
        }
        return false;
    }
}
