package menu.model.enums;

import java.util.Arrays;

public enum Category {
    Japanese(1, "일식"),
    Korean(2, "한식"),
    Chinese(3, "중식"),
    Asian(4, "아시안"),
    Western(5, "양식");

    private static final String NO_CATEGORY_MESSAGE = "[ERROR]해당 번호의 카테고리가 없습니다.";
    private final int number;
    private final String name;

    Category(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static Category byNumber(int number) {
        return Arrays.stream(values())
                .filter(v -> v.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(NO_CATEGORY_MESSAGE));
    }
}
