package menu.type;

public enum CategoryType {
    JAPAN("일식", 1),
    KOREA("한식", 2),
    CHINA("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String category;
    private final int number;

    CategoryType(String category, int number) {
        this.category = category;
        this.number = number;
    }

    private String getCategory() {
        return this.category;
    }

    public int getNumber() {
        return this.number;
    }
}
