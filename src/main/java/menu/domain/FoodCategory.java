package menu.domain;

public enum FoodCategory {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    ITALIAN(5, "양식");

    protected final int categoryNumber;
    protected final String categoryName;

    FoodCategory(int categoryNumber, String categoryName) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public static FoodCategory categoryNumberToFoodCategory(int num) {
        if(num == 1) {
            return FoodCategory.JAPANESE;
        } else if(num == 2) {
            return FoodCategory.KOREAN;
        } else if(num == 3) {
            return FoodCategory.CHINESE;
        } else if(num == 4) {
            return FoodCategory.ASIAN;
        } else if(num == 5) {
            return FoodCategory.ITALIAN;
        }
        return null;
    }
}
