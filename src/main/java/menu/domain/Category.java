package menu.domain;

public enum Category {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category of(int index) {
        index--;
        if (index >= 5) {
            index--;
        }
        Category[] categories = Category.values();
        return categories[index];
    }
}
