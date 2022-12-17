package menu.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {

    JAPAN_FOOD(1, "일식"),
    KOREA_FOOD(2, "한식"),
    CHINA_FOOD(3, "중식"),
    ASIA_FOOD(4, "아시아"),
    EUROPE_FOOD(5, "양식");

    private final int number;
    private final String name;

    Category(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static List<Integer> getNumbers() {
        return Arrays.stream(Category.values())
                .map(Category::getNumber)
                .collect(Collectors.toList());
    }

    public int getNumber() {
        return number;
    }

    public static Category from(int number) {
        return Arrays.stream(Category.values())
                .filter(category -> category.isEqualNumber(number))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }

    private boolean isEqualNumber(int number) {
        return this.number == number;
    }
}
