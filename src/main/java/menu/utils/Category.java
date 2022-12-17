package menu.utils;

import java.util.Arrays;

public enum Category {
    JAPAN("일식",1),
    KOREA("한식", 2),
    CHINA("중식",3),
    ASIA("아시안",4),
    WESTERN("양식",5);

    private final String category;
    private final int pickNumber;

    Category(String category, int pickNumber) {
        this.category = category;
        this.pickNumber = pickNumber;
    }

    public static Category valueOfPickNumber(int pickNumber) {
        return Arrays.stream(values())
                .filter(value -> value.pickNumber == pickNumber)
                .findAny()
                .orElse(null);
    }

    public String getCategory() {
        return category;
    }

    public int getPickNumber() {
        return pickNumber;
    }
}
