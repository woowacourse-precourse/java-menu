package menu.model.domain;

public enum Category {

    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIA("아시안"),
    AMERICA("양식");

    private String category;

    Category(String category) {
        this.category = category;
    }
}
