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
        while (categories.size() != 5) {
            int key = Randoms.pickNumberInRange(1, 5);
            String category = getCategory(key);
            if (categories.stream().filter(x -> x.equals(category)).count() < 2) {
                categories.add(category);
            }
        }
        return categories;
    }
}
