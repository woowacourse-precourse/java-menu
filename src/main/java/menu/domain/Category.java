package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static final String DOES_NOT_EXIST_CATEGORY_ERROR = "존재하지 않는 카테고리입니다.";

    private final int number;
    private final String categoryName;

    Category(int number, String categoryName) {
        this.number = number;
        this.categoryName = categoryName;
    }

    public static Category fromInput(int input) {
        return Arrays.stream(values())
                .filter(menu -> menu.getNumber() == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(DOES_NOT_EXIST_CATEGORY_ERROR));
    }

    public int getNumber() {
        return number;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
