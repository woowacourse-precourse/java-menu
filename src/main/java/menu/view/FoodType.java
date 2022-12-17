package menu.view;

public enum FoodType {
    KOREAN_FOOD(1),
    CHINESE_FOOD(2),
    JAPANESE_FOOD(3),
    ASIAN_FOOD(4),
    WESTERN_FOOD(5);

    private final int foodtype;

    FoodType(int foodtype) {
        this.foodtype = foodtype;
    }

    public int getFoodtype() {
        return this.foodtype;
    }
}
