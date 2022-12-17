package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

public enum Category {
    JAPANESE_FOOD("일식", 1),
    KOREAN_FOOD("한식", 2),
    CHINESE_FOOD("중식", 3),
    ASIAN_FOOD("아시안", 4),
    WESTON_FOOD("양식", 5);

    private final String category;
    private final Integer index;

    Category(String category, Integer index) {
        this.category = category;
        this.index = index;
    }

    public static String recommendCategory() {
        Integer randomNumber = Randoms.pickNumberInRange(1, 5);
        for (Category name : Category.values()) {
            if (name.index.equals(randomNumber)) {
                return name.category;
            }
        }
        return null;
    }
}
