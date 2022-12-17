package menu.domain;

public enum Category {
    JAPAN("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String name;

    Category(String name) {
        this.name = name;
    }
}
