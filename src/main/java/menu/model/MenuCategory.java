package menu.model;

import java.util.Arrays;

import static menu.utils.Errors.NOT_EXIST_CATEGORY;

public enum MenuCategory {
    JAPAN("일식", 1),
    KOREA("한식", 2),
    CHINA("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String category;
    private final int number;

    MenuCategory(final String category, final int number) {
        this.category = category;
        this.number = number;
    }

    public static MenuCategory pickCategory(final int number) {
        return Arrays.stream(values())
                .filter(category -> category.equalsNumber(number))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(NOT_EXIST_CATEGORY.getMessage()));
    }

    private boolean equalsNumber(final int number) {
        return this.number == number;
    }

    public String getCategory() {
        return this.category;
    }
}
