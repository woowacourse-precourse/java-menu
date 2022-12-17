package menu.domain;

public enum Category {
    JAPAN(1, "일식"),
    KOREA(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    AMERICA(5, "양식");

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

    public String getMessage() {
        return message;
    }
}
