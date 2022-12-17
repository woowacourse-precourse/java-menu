package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.exception.GlobalExceptionMessage.WRONG_CATEGORY_TYPE_EXCEPTION;

public enum Category {
    JAPANESE_FOOD_CATEGORY("일식", 1),
    KOREAN_FOOD_CATEGORY("한식", 2),
    CHINESE_FOOD_CATEGORY("중식", 3),
    ASIAN_FOOD_CATEGORY("아시안", 4),
    WESTERN_FOOD_CATEGORY("양식", 5);

    private final String name;
    private final int type;

    Category(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public static Category from(int type) {
        return Arrays.stream(Category.values())
                .filter(category -> category.type == type)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_CATEGORY_TYPE_EXCEPTION.getMessage()));
    }

    public boolean isJapaneseFood() {
        return this == JAPANESE_FOOD_CATEGORY;
    }

    public boolean isKoreanFood() {
        return this == KOREAN_FOOD_CATEGORY;
    }

    public boolean isChineseFood() {
        return this == CHINESE_FOOD_CATEGORY;
    }

    public boolean isAsianFood() {
        return this == ASIAN_FOOD_CATEGORY;
    }

    public boolean isWesternFood() {
        return this == WESTERN_FOOD_CATEGORY;
    }

    public boolean isSame(Category category) {
        return this == category;
    }

    public String getName() {
        return name;
    }
}
