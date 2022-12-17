package menu.domain;

public enum Category {

    JAPANESE("1"),
    KOREAN("2"),
    CHINESE("3"),
    ASIAN("4"),
    WESTERN("5");

    private final String categoryNumber;

    Category(String categoryNumber) {
        this.categoryNumber = categoryNumber;
    }
}
