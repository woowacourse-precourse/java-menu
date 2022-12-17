package menu.domain.menu.type;

import java.util.Arrays;
import menu.domain.menu.exception.CategoryNotFoundException;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int number;
    private final String name;

    Category(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static Category findByNumber(int number) {
        return Arrays.stream(Category.values()).filter(category -> category.number == number).findFirst()
            .orElseThrow(CategoryNotFoundException::new);
    }

}
