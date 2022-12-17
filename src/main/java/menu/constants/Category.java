package menu.constants;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Category {
    JAPANESE_FOOD(1, "일식", Arrays.asList("규동", "우동", "미소시루", "스시",
            "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_FOOD(2, "한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개",
            "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_FOOD(3, "중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면",
            "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_FOOD(4, "아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝",
            "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN_FOOD(5,"양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈",
            "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private static final List<String> ALL_MENU = Stream.of(JAPANESE_FOOD.menus, KOREAN_FOOD.menus,
                    CHINESE_FOOD.menus, ASIAN_FOOD.menus, WESTERN_FOOD.menus)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    private static final Map<Integer, Category> CATEGORY_BY_NUMBER = Stream.of(values())
            .collect(Collectors.toMap(Category::getCategoryNumber, Function.identity()));

    private final int categoryNumber;
    private final String category;
    private final List<String> menus;

    Category(int categoryNumber, String category, List<String> menus) {
        this.categoryNumber = categoryNumber;
        this.category = category;
        this.menus = menus;
    }

    private int getCategoryNumber() {
        return categoryNumber;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public static boolean isExistMenu(String menu) {
        return ALL_MENU.contains(menu);
    }

    public static Category getCategoryByNumber(int number) {
        return CATEGORY_BY_NUMBER.get(number);
    }
}
