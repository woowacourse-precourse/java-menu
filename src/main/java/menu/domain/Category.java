package menu.domain;

public enum Category {
    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIAN("아시안"),
    AMERICA("양식");

    private final String message;

    Category(String message) {
        this.message = message;
    }
}
