package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE(1), KOREAN(2), CHINESE(3), ASIAN(4), WESTERN(5);

    private int id;

    Category(int id) {
        this.id = id;
    }

    public static Category findById(int id) {
        return Arrays.stream(values())
                .filter(category -> category.id == id)
                .findAny()
                .get();
    }
}
