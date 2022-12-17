package menu.domain;

import java.util.Arrays;

public enum Category {
    KOREA("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    JAPANESE("일식"),
    WEST("양식");

    private static final String INVALID_CATEGORY_VALUE_MESSAGE = "유효하지 않은 값입니다.";
    private final String name;

    Category(String name) {
        this.name = name;
    }

    //TODO: val의 네이밍 꼭 변경하기
    public Category from(String name) {
        return Arrays.stream(values())
                .filter(category -> category.name == name)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CATEGORY_VALUE_MESSAGE));
    }
}
