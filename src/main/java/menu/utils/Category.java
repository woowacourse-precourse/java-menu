package menu.utils;

import java.util.List;
import java.util.StringJoiner;

public enum Category {
    JAPAN(1, "일식"),
    KOREA(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    AMERICA(5, "양식");

    private static final String DELIMITER = " | ";
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String INIT = "카테고리";

    public static final int MIN = 1;
    public static final int MAX = 5;

    private final String message;
    private final int code;

    Category(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public static Category from(int code) {
        for (Category value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    public static String toMessage(List<Category> categories) {
        StringJoiner joiner = new StringJoiner(" | ");
        joiner.add(INIT);
        categories.forEach(category -> joiner.add(category.getMessage()));
        return PREFIX + joiner + SUFFIX;
    }

    public String getMessage() {
        return message;
    }
}
