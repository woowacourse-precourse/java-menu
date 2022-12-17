package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public enum Category {
    JAPAN("일식", 1),
    KOREA("한식", 2),
    CHINA("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private String name;
    private int value;

    Category(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static Category pickRandomCategory() {
        int category = Randoms.pickNumberInRange(1, 5);

        return Arrays.stream(Category.values())
            .filter(c -> c.value == category)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 없는 카테고리 값입니다."));
    }
}
