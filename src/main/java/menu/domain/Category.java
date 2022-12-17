package menu.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String name;
    private final int categoryNumber;

    Category(String name, int categoryNumber) {
        this.name = name;
        this.categoryNumber = categoryNumber;
    }

    public String getName() {
        return name;
    }

    public Category getCategoryByNumber(int number) {
        Optional<Category> category = Arrays.stream(Category.values())
                .filter(c -> c.categoryNumber == number)
                .findFirst();

        return category.orElse(null);
    }
}
