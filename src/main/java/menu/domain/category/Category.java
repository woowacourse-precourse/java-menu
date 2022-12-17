package menu.domain.category;

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
}
