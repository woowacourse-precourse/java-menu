package menu.domain.menu;

import menu.domain.FoodCategory;

import java.util.List;

public class AsianMenu {

    public FoodCategory foodCategory;
    public List<String> japaneseFoods;

    public AsianMenu() {
        this.foodCategory = FoodCategory.ASIAN;
        this.japaneseFoods = List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    }

    public boolean isContain(String foodName) {
        if (japaneseFoods.contains(foodName)) {
            return true;
        }
        return false;
    }
}
