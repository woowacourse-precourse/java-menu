package menu.domain;

import java.util.Arrays;

public enum FoodCategory {
    JAPANESE(1),
    KOREAN(2),
    CHINESE(3),
    ASIAN(4),
    WESTERN(5);

    private final int number;

    FoodCategory(int number) {
        this.number = number;
    }

    public static FoodCategory findByNumber(int inputNumber) {
        return Arrays.stream(values())
            .filter(category -> category.number == inputNumber)
            .findAny()
            .get();
    }
}
