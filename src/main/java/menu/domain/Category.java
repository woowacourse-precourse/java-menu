package menu.domain;

public enum Category {
    KOREA("한식"),
    WEST("양식"),
    JAPAN("일식"),
    CHINA("중식"),
    ASIA("아시안");

    private final String foodCategory;

    Category(String foodCategory) {
        this.foodCategory = foodCategory;
    }


    @Override
    public String toString() {
        return foodCategory;
    }
}
