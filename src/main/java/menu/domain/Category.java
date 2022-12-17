package menu.domain;

import java.util.stream.Stream;

public enum Category {
    JAPAN(1, "일식"),
    KOREAN(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    AMERICAN(5, "양식");

    private final int index;
    private final String name;

    Category(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static Category findCategory(int index) {
        return Stream.of(values())
                .filter(value -> value.isSameIndex(index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(" 카테고리 번호를 확인해주세요."));
    }

    private boolean isSameIndex(int index) {
        return this.index == index;
    }
}
