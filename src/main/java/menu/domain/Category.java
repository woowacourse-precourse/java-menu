package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    AMERICAN("양식", 5);

    private final String title;
    private final int index;

    Category(String title, int index) {
        this.title = title;
        this.index = index;
    }

    public static Category map(String input) {
        return Arrays.stream(values())
                .filter(m -> m.title.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    public static String getByIndex(int index) {
        return Arrays.stream(values())
                .filter(m -> m.index == index)
                .findAny()
                .map(m -> m.title)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

}
