package menu.constant;

import java.util.Arrays;

public enum Category {

    JAPANESE(1), KOREAN(2), CHINESE(3), ASIAN(4), WESTERN(5);

    private final int number;

    Category(int number) {
        this.number = number;
    }

    public static Category from(int number) {
        return Arrays.stream(values())
                .filter(category -> category.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾지 못했습니다"));
    }
}
