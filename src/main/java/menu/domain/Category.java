package menu.domain;

import java.util.Arrays;

import static menu.constant.SystemConstant.ERROR_PREFIX;

public enum Category {

    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int command;
    private final String categoryName;

    Category(int command, String categoryName) {
        this.command = command;
        this.categoryName = categoryName;
    }

    public static Category from(int command) {
        return Arrays.stream(Category.values())
                .filter(category -> category.command == command)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 카테고리입니다."));
    }
}
