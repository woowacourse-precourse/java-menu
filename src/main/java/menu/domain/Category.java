package menu.domain;

public enum Category {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String category;

    Category(String category) {
        this.category = category;
    }
}
