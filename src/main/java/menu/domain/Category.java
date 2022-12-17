package menu.domain;

import java.util.Arrays;

public enum Category {

    JAPANESE(1,"일식"),
    KOREAN(2,"한식"),
    CHINESE(3,"중식"),
    ASIAN(4,"아시안"),
    WESTERN(5,"양식");

    private final int order;
    private final String name;

    Category(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category of(int input) {
        return Arrays.stream(values())
                .filter(category -> category.order == input)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 카테고리 순서입니다. 입력값 : " + input));
    }
}
