package menu.domain;

import java.util.List;
import menu.util.FoodData;

public enum Category {

    JAPANESE(1, FoodData.JAPANESE_FOOD),
    KOREAN(2, FoodData.KOREAN_FOOD),
    CHINESE(3, FoodData.CHINESE_FOOD),
    ASIAN(4, FoodData.ASIAN_FOOD),
    WESTERN(5, FoodData.WESTERN_FOOD);

    private final int code;
    private final List<String> foodNames;

    Category(int code, List<String> foodNames) {
        this.code = code;
        this.foodNames = foodNames;
    }

    public List<String> getFoodNames() {
        return this.foodNames;
    }

}
