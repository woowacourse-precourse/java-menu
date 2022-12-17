package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPAN(1, "일식"),
    KOREA(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static final String INVALID_CATEGORY_MESSAGE = "존재하지 않는 카테고리입니다.";

    private final Integer command;
    private final String name;

    Category(Integer command, String name) {
        this.command = command;
        this.name = name;
    }

    public static Category of(Integer number) {
        return Arrays.stream(Category.values())
                .filter(category -> category.command == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CATEGORY_MESSAGE));
    }

    public String getName() {
        return name;
    }
}
