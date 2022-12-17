package menu.model;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식", Food.JAPANESE_FOOD),
    KOREAN(2, "한식", Food.KOREAN_FOOD),
    CHINESE(3, "중식", Food.CHINESE_FOOD),
    ASIAN(4, "아시안", Food.ASIAN_FOOD),
    WESTERN(5, "양식", Food.WESTERN_FOOD);
    
    private final int categoryId;
    private final String categoryName;
    private final Food food;
    
    Category (int categoryId, String categoryName, Food food) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.food = food;
    }

    public static Category of(int categoryId) {
        return Arrays.stream(Category.values())
                .filter(category -> category.categoryId == categoryId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 생성값이 아닙니다."));
    } 
}
