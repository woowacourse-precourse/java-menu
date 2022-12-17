package menu.domain.menu;

import menu.domain.FoodCategory;

import java.util.List;

public class KoreanMenu implements SpecificMenu {

    public FoodCategory foodCategory;

    public List<String> koreanFoods;

    public KoreanMenu() {
        this.foodCategory = FoodCategory.KOREAN;
        this.koreanFoods = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    }

    public boolean isContain(String foodName) {
        if (koreanFoods.contains(foodName)) {
            return true;
        }
        return false;
    }
    public List<String> getFoodsList() {
        return koreanFoods;
    }
}
