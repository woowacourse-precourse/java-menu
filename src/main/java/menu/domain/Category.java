package menu.domain;

public enum Category {
    KOREAN("한식"),
    JAPANESE("일식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    AMERICAN("양식");

    private final String name;

    Category(String title) {
        this.name = title;
    }
}
