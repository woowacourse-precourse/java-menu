package menu.domain.menu;

import menu.domain.FoodCategory;

import java.util.List;

public class ChineseMenu {
    public FoodCategory foodCategory;
    public List<String> japaneseFoods;

    public ChineseMenu() {
        this.foodCategory = FoodCategory.CHINESE;
        this.japaneseFoods = List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
    }

    public boolean isContain(String foodName) {
        if (japaneseFoods.contains(foodName)) {
            return true;
        }
        return false;
    }
}

