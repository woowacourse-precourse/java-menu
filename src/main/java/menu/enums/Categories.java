package menu.enums;

public enum Categories {
    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String name;

    Categories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
