package menu.enums;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private int num;
    private String label;

    Category(int num, String label) {
        this.num = num;
        this.label = label;
    }

    public static Category valueOfLabel(String label) {
        return Arrays.stream(values())
                .filter(value -> value.label.equals(label))
                .findAny()
                .orElse(null);
    }

    public static Category valueOfNum(int num) {
        return Arrays.stream(values())
                .filter(value -> value.num == num)
                .findAny()
                .orElse(null);
    }
}
