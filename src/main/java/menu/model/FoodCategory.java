package menu.model;

public enum FoodCategory {
    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String category;

    FoodCategory(final String category) {
        this.category = category;
    }
}
