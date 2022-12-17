package menu.domain;

import java.util.Arrays;

public enum Category {

    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIA("아시안"),
    AMERICA("양식");

    Category(String name) {
        this.name = name;
    }

    private final String name;

    public static Category from(String name) {
        return Arrays.stream(Category.values())
                .filter(category -> category.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 카테고리입니다."));
    }
}
