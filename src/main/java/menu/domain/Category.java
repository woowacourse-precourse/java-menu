package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREA("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WEST("양식", 5);

    public static final int MIN_CATEGORY_CODE = 1;
    public static final int MAX_CATEGORY_CODE = 5;
    private static final String INVALID_CATEGORY_VALUE_MESSAGE = "유효하지 않은 값입니다.";
    private final String name;
    private final int code;

    Category(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public static Category from(int code) {
        return Arrays.stream(values())
                .filter(category -> category.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CATEGORY_VALUE_MESSAGE));
    }
}
