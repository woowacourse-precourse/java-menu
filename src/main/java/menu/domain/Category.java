package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    JAPAN("일식", 0),
    KOREA("한식", 1),
    CHINA("중식", 2),
    ASIAN("아시안", 3),
    WESTERN("양식", 4);


    private static final String INVALID_INDEX = "인덱스는 0부터 4사이의 숫자여야 합니다.";
    private static final String INVALID_NAME = "존재하지 않는 이름입니다.";

    private final String name;
    private final int index;

    Category(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static Category getCategoryByIndex(int index) {
        return Arrays.stream(Category.values())
                .filter(category -> category.index == index)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INDEX));
    }

    public static Category getCategoryByName(String name) {
        return Arrays.stream(Category.values())
                .filter(category -> name.equals(category.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NAME));

    }

    public static List<Integer> getIndexNumbers() {
        return Arrays.stream(Category.values())
                .map(category -> category.index)
                .collect(Collectors.toUnmodifiableList());
    }

    public String getName() {
        return name;
    }
}
