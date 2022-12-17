package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String keyword;

    Category(String keyword) {
        this.keyword = keyword;
    }

    public static Category from(String keyword) {
        return Arrays.stream(Category.values())
                .filter(it -> it.keyword.equals(keyword))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다"));
    }
}
