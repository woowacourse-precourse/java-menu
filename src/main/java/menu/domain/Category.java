package menu.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Category {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    WESTERN("양식"),
    ASIAN("아시안");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public static Category of(String name) {
        return Arrays.stream(Category.values())
                .filter(category -> Objects.equals(category.name, name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 카테고리를 찾을 수 없습니다."));
    }
}
