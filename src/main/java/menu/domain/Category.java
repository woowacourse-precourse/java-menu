package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPAN(1, "일식"),
    KOREA(2,"한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN (5, "양식");

    private final int foodNumber;
    public final String foodType;


    Category(int foodNumber, String foodType) {
        this.foodNumber = foodNumber;
        this.foodType = foodType;
    }

    public int getFoodNumber() {
        return foodNumber;
    }

    public String getFoodType() {
        return foodType;
    }
}
