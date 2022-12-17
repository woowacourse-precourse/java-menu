package domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식"), KOREAN("한식"), CHINESE("중식"), ASIAN("아시안"), WESTERN("양식");

    private final String name;

    Category(String category) {
        this.name = category;
    }

    public String getName() {
        return name;
    }

    public static Category findCategoryByName(String name) {
        return Arrays.stream(Category.values())
                     .filter(category -> category.getName()
                                                 .equals(name))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 메뉴 입니다."));
    }
}
