package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static final String INVALID_CATEGORY_MESSAGE = "올바른 카테고리 이름을 입력해주세요.";

    public int categoryNumber;
    public String name;

    Category(int categoryNumber, String name) {
        this.categoryNumber = categoryNumber;
        this.name = name;
    }

    public static Category getByName(String name) {
        return Arrays.stream(Category.values())
                .filter(category -> category.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CATEGORY_MESSAGE));
    }

    public String getName() {
        return name;
    }
}
