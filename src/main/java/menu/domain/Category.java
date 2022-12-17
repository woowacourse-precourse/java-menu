package menu.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String name;
    private final int number;

    Category(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public static Category of(String name) {
        return Arrays.stream(Category.values())
                .filter(category -> Objects.equals(category.name, name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 카테고리를 찾을 수 없습니다."));
    }
}
