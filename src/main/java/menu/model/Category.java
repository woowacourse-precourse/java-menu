package menu.model;

public enum Category {
    JAPANESE_FOOD("일식"),
    KOREAN_FOOD("한식"),
    CHINESE_FOOD("중식"),
    ASIAN_FOOD("아시안"),
    WESTON_FOOD("양식");

    private String category;

    Category(String category) {
        this.category = category;
    }
}
