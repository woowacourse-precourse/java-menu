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

    Category(final String keyword, final int key) {
        this.key = key;
        this.keyword = keyword;
    }

    public static Category findCategory(final String keyword) {
        return Arrays.stream(values())
                .filter(e -> e.keyword.equals(keyword))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다"));
    }

    public static Category findCategory(final int key) {
        return Arrays.stream(values())
                .filter(e -> e.key == key)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다"));
    }

}