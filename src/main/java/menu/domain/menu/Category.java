package menu.domain.menu;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    AMERICAN("양식");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    public static Category map(String input) {
        return Arrays.stream(values())
                .filter(m -> m.title.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    public static String getByOrdinal(int index) {
        return Arrays.stream(values())
                .filter(m -> m.ordinal() == index)
                .findAny()
                .map(m -> m.title)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    public String getTitle() {
        return title;
    }
}
