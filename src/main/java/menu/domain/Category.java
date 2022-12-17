package menu.domain;

import java.util.Arrays;
import java.util.List;
import menu.util.FoodData;
import menu.util.constants.ExceptionMessage;

public enum Category {

    JAPANESE(1, "일식", FoodData.JAPANESE_FOOD),
    KOREAN(2, "한식", FoodData.KOREAN_FOOD),
    CHINESE(3, "중식", FoodData.CHINESE_FOOD),
    ASIAN(4, "아시안", FoodData.ASIAN_FOOD),
    WESTERN(5, "양식", FoodData.WESTERN_FOOD);

    private final int code;
    private final String koreanName;
    private final List<String> foodNames;

    Category(int code, String koreanName, List<String> foodNames) {
        this.code = code;
        this.koreanName = koreanName;
        this.foodNames = foodNames;
    }

    public List<String> getFoodNames() {
        return this.foodNames;
    }

    public String getKoreanName() {
        return this.koreanName;
    }

    public static Category findCategoryByCode(int inputCode) {
        return Arrays.stream(Category.values())
                .filter(category -> inputCode == category.code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_MATCHING_CATEGORY));

    }

}
