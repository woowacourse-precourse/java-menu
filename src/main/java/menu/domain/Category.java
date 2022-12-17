package menu.domain;

public enum Category {
    CATEGORY("카테고리"),
    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIA("아시안"),
    AMERICA("양식")
    ;

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
