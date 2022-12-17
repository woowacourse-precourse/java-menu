package menu.domain.category;

import java.util.Arrays;

public enum Category {
    JAPANESE_FOOD(1),
    KOREAN_FOOD(2),
    CHINESE_FOOD(3),
    ASIAN_FOOD(4),
    WESTERN_FOOD(5);
    
    private final int categoryNumber;
    
    Category(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }
    
    public static Category findByCategoryNumber(int categoryNumber) {
        return Arrays.stream(values())
                .filter(category -> category.isSameCategoryNumber(categoryNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 카테고리입니다."));
    }
    
    private boolean isSameCategoryNumber(int categoryNumber) {
        return this.categoryNumber == categoryNumber;
    }
}
