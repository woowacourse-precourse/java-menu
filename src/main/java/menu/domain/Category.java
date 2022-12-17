package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

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
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다"));
    }

    public static Category from(int key) {
        return Arrays.stream(Category.values())
                .filter(it -> it.key == key)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다"));
    }

    public String toDto() {
        return keyword;
    }
}
