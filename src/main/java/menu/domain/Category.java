package menu.domain;

import java.util.Arrays;

public enum Category {

    JAPANESE(1),
    KOREAN(2),
    CHINESE(3),
    ASIAN(4),
    WESTERN(5);

    private final int order;

    Category(int order) {
        this.order = order;
    }


    public static Category of(int input) {
        return Arrays.stream(values())
                .filter(category -> category.order == input)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 카테고리 순서입니다. 입력값 : " + input));
    }
}
