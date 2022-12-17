package domain;

public enum Categories {
    JAPANESE("일식"), KOREAN("한식"), CHINESE("중식"), ASIAN("아시안"), WESTERN("양식");

    private final String category;

    Categories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
