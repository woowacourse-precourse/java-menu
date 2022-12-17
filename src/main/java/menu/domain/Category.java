package menu.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Category {
    JAPAN("1", "일식"),
    KOREA("2", "한식"),
    CHINA("3", "중식"),
    ASIAN("4", "아시안"),
    WESTERN("5", "양식");

    private final String code;
    private final String name;

    Category(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Category fromCode(String code) {
        return Arrays.stream(values())
                .filter(category -> Objects.equals(category.code, code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("카테고리 오류"));
    }

    public static Category fromName(String name) {
        return Arrays.stream(values())
                .filter(category -> Objects.equals(category.name, name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("카테고리 오류"));
    }

    public String getName() {
        return name;
    }
}
