package menu.util;

import java.util.Arrays;

public enum MenuCategory {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    ITALIAN("양식", 5);

    private final String name;
    private final int randomNumber;

    MenuCategory(String name, int randomNumber) {
        this.name = name;
        this.randomNumber = randomNumber;
    }

    public String getName() {
        return this.name;
    }

    public int get() {
        return this.randomNumber;
    }

    public static MenuCategory findCategory(int randomNumber) {
        return Arrays.stream(MenuCategory.values())
                .filter(category -> category.get() == randomNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
