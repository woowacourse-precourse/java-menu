package menu.domain.menu;

import menu.domain.FoodCategory;

import java.util.List;

public class KoreanMenu {

    public FoodCategory foodCategory;
    public List<String> japaneseFoods;

    public KoreanMenu() {
        this.foodCategory = FoodCategory.KOREAN;
        this.japaneseFoods = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    }

    public boolean isContain(String foodName) {
        if (japaneseFoods.contains(foodName)) {
            return true;
        }
        return false;
    }
}
