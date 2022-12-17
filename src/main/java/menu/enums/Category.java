package menu.enums;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum Category {
    CATEGORY_JAPAN(1, "일식"),
    CATEGORY_KOREA(2, "한식"),
    CATEGORY_CHINA(3, "중식"),
    CATEGORY_ASIA(4, "아시안"),
    CATEGORY_WESTERN(5, "일식");

    Category(int number, String name) {
        this.number = number;
        this.name = name;
    }

    private final int number;
    private final String name;

    public int getNumber() {
        return number;
    }

    public static Category getCategoryFromNumber(int inputNum) {
        return Arrays.stream(Category.values())
                .filter(c -> c.number == inputNum)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 카테고리 번호입니다."));
    }

}
