package menu.constant;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

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

    public static Category from(int number) {
        return Arrays.stream(values())
                .filter(category -> category.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾지 못했습니다"));
    }

    public static Category pickRandomCategory() {

        return Category.from(Randoms.pickNumberInRange(getMinNumber(), getMaxNumber()));
    }

    private static int getMinNumber() {
        int min = Integer.MAX_VALUE;
        for (Category category : values()) {
            min = Math.min(category.number, min);
        }
        return min;
    }

    private static int getMaxNumber() {
        int max = Integer.MIN_VALUE;
        for (Category category : values()) {
            max = Math.max(category.number, max);
        }
        return max;
    }

    public String getName() {
        return name;
    }
}
