package menu.domain;

import java.util.Arrays;

public enum Category {

    JAPAN("일식", 1),
    KOREA("한식", 2),
    CHINA("중식", 3),
    ASIA("아시안", 4),
    AMERICA("양식", 5);

    Category(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static Category from(String name) {
        return Arrays.stream(Category.values())
                .filter(category -> category.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    public static Category from(int value) {
        return Arrays.stream(Category.values())
                .filter(category -> category.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }
}
