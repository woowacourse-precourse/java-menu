package menu.domain;

import java.util.Arrays;

public enum FoodCategory {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int number;
    private final String name;

    FoodCategory(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static FoodCategory findByNumber(int inputNumber) {
        return Arrays.stream(values())
            .filter(category -> category.number == inputNumber)
            .findAny()
            .get();
    }

    public String getName() {
        return name;
    }
}
