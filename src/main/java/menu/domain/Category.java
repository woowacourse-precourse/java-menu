package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);
    private static final String CATEGORY_NOT_FOUND_MESSAGE = "카테고리가 존재하지 않습니다";

    private final String keyword;
    private final int key;

    Category(String keyword, int key) {
        this.key = key;
        this.keyword = keyword;
    }

    public static Category from(String keyword) {
        return Arrays.stream(Category.values())
                .filter(it -> it.keyword.equals(keyword))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CATEGORY_NOT_FOUND_MESSAGE));
    }

    public static Category from(int key) {
        return Arrays.stream(Category.values())
                .filter(it -> it.key == key)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CATEGORY_NOT_FOUND_MESSAGE));
    }

    public String toDto() {
        return keyword;
    }
}
