package menu.domain.menu;

import menu.domain.FoodCategory;

import java.util.List;

public class ItalianMenu implements SpecificMenu {

    public FoodCategory foodCategory;
    public List<String> italianFoods;

    public ItalianMenu() {
        this.foodCategory = FoodCategory.ITALIAN;
        this.italianFoods = List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
    }

    public boolean isContain(String foodName) {
        if (italianFoods.contains(foodName)) {
            return true;
        }
        return false;
    }

    public List<String> getFoodsList() {
        return italianFoods;
    }
}
