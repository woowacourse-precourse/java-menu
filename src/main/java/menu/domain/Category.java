package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static final String INVALID_CATEGORY_NAME_MESSAGE = "올바른 카테고리 이름을 입력해주세요.";
    private static final String INVALID_CATEGORY_NUMBER_MESSAGE = "올바른 카테고리 번호을 입력해주세요.";

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
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CATEGORY_NAME_MESSAGE));
    }

    public static Category getByNumber(int number) {
        return Arrays.stream(Category.values())
                .filter(category -> category.categoryNumber == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CATEGORY_NUMBER_MESSAGE));
    }

    public String getName() {
        return name;
    }
}
