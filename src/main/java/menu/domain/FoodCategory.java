package menu.domain;

public enum FoodCategory {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");
    String name;

    FoodCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
