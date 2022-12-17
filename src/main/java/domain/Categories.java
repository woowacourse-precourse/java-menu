package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public enum Categories {
    JAPAN(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static final int WEEKDAY = 5;
    private static final int STARTER = 1;
    private static final int LIMIT_OF_REPETITION = 2;
    private final int key;
    private final String category;

    Categories(int key, String category) {
        this.key = key;
        this.category = category;
    }

    private static String getCategory(int key) {
        return Arrays.stream(Categories.values())
            .filter(category -> category.key == key)
            .collect(Collectors.toList())
            .get(0).category;
    }

    public static List<String> generateCategories() {
        List<String> categories = new ArrayList<>();
        while (categories.size() != WEEKDAY) {
            int key = Randoms.pickNumberInRange(STARTER, Categories.values().length);
            String category = getCategory(key);
            if (categories.stream().filter(x -> x.equals(category)).count() < LIMIT_OF_REPETITION) {
                categories.add(category);
            }
        }
        return categories;
    }
}
