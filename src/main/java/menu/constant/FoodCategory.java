package menu.constant;

import java.util.Arrays;

public enum FoodCategory {
    JAPAN(1, "일식"),
    KOREA(2, "한식"),
    CHINA(3, "중국"),
    ASIA(4, "아시안"),
    WEST(5, "양식");

    private final int key;
    private final String foodCategory;

    FoodCategory(int key, String foodCategory) {
        this.key = key;
        this.foodCategory = foodCategory;
    }

    public static String findFoodByKey(int key) {
        return Arrays.stream(FoodCategory.values())
                .filter(elem -> key == elem.key)
                .findAny()
                .orElseThrow()
                .getFoodCategory();
    }

    public int getKey() {
        return key;
    }

    public String getFoodCategory() {
        return foodCategory;
    }
}
