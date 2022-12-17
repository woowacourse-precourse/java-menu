package menu.domain;

import java.util.Arrays;

public enum CategoryEnum {
    ONE("일식", 1),
    TWO("한식", 2),
    THREE("중식", 3),
    FOUR("아시안", 4),
    FIVE("양식", 5),
    EMPTY("", 0);

    private final String categoryName;
    private final Integer categoryNumber;

    CategoryEnum(String categoryName, Integer categoryNumber) {
        this.categoryName = categoryName;
        this.categoryNumber = categoryNumber;
    }

    public static String getTransferCategoryName(int val) {
        return Arrays.stream(CategoryEnum.values())
                .filter(category -> category.categoryNumber == val)
                .findAny()
                .orElse(EMPTY)
                .getTransferCategoryName();
    }

    private String getTransferCategoryName() {
        return categoryName;
    }
}
