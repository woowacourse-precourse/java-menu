package menu;

import java.util.Arrays;

public enum Category {

    일식("1"),
    한식("2"),
    중식("3"),
    아시안("4"),
    양식("5");

    private final String value;

    Category(String input) {
        value = input;
    }

    public static Category from(String input) {
        return Arrays.stream(Category.values())
                .filter(it -> it.value.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
    }
}
