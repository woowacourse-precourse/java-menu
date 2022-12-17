package menu.domain;

public enum Category {
    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIA("아시안"),
    WEST("양식");

    private final String foodCategory;

    Category(String foodCategory) {
        this.foodCategory = foodCategory;
    }


    @Override
    public String toString() {
        return foodCategory;
    }
}
