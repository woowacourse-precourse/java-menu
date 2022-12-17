package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

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

    public static Category getRandomCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        return Arrays.stream(Category.values())
                .filter(category -> category.number == randomNumber)
                .findAny()
                .get();
    }

    public String getName() {
        return name;
    }
}