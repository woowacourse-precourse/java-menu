package menu;

import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPAN("일식",1),
    KOREA("한식",2),
    CHINA("중식",3),
    ASIAN("아시안",4),
    EAST("양식",5);

    private String name;
    private int number;
    Category(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static Category getValueOf(int number) {
        return Arrays.stream(Category.values())
                .filter(x -> x.getNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
