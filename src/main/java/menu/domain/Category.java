package menu.domain;

public enum Category {
    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private String name;

    Category(String name) {
        this.name = name;
    }
}
