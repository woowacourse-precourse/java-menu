package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1), KOREAN("한식", 2), CHINESE("중식", 3), ASIAN("아시안", 4), WESTERN("양식", 5);

    private String name;
    private int id;

    Category(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static Category findById(int id) {
        return Arrays.stream(values())
                .filter(category -> category.id == id)
                .findAny()
                .get();
    }
}
