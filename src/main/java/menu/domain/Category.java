package menu.domain;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int categoryNumber;
    private final String categoryName;

    Category(int categoryNumber, String categoryName) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
    }
}
