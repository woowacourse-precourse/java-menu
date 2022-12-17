package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Category {

    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static final List<String> JAPANESE_FOOD = List.of(
            "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"
    );
    private static final List<String> KOREAN_FOOD = List.of(
            "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"
    );
    private static final List<String> CHINESE_FOOD = List.of(
            "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"
    );
    private static final List<String> ASIAN_FOOD = List.of(
            "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"
    );
    private static final List<String> WESTERN_FOOD = List.of(
            "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"
    );

    private static final String INVALID_NUMBER = "카테고리 선정을 하려면 1에서 5 사이의 숫자를 입력해주세요.";

    private final int number;
    private final String categoryName;

    Category(int number, String categoryName) {
        this.number = number;
        this.categoryName = categoryName;
    }

    public static String findCategoryNameBy(int RandomNumber) {
        return Arrays.stream(values())
                .filter(category -> category.number == RandomNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NUMBER))
                .getCategoryName();
    }

    public static List<String> findFoodBy(int RandomNumber) {
        return Arrays.stream(values())
                .filter(category -> category.number == RandomNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NUMBER))
                .getFood();
    }

    public static List<String> findCategoryBy(String categoryName) {
        return Arrays.stream(values())
                .filter(category -> category.categoryName.equals(categoryName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException())
                .getFood();
    }

    private List<String> getFood() {
        if (this.equals(JAPANESE)) {
            return JAPANESE_FOOD;
        }
        if (this.equals(KOREAN)) {
            return KOREAN_FOOD;
        }
        if (this.equals(CHINESE)) {
            return CHINESE_FOOD;
        }
        if (this.equals(ASIAN)) {
            return ASIAN_FOOD;
        }
        return WESTERN_FOOD;
    }

    public static int findNumberBy(String menu) {
        if (JAPANESE_FOOD.contains(menu)) {
            return JAPANESE.number;
        }
        if (KOREAN_FOOD.contains(menu)) {
            return KOREAN.number;
        }
        if (CHINESE_FOOD.contains(menu)) {
            return CHINESE.number;
        }
        if (ASIAN_FOOD.contains(menu)) {
            return ASIAN.number;
        }
            return WESTERN.number;
    }

    public static String findCategoryNameBy(String menu) {
        if (JAPANESE_FOOD.contains(menu)) {
            return JAPANESE.categoryName;
        }
        if (KOREAN_FOOD.contains(menu)) {
            return KOREAN.categoryName;
        }
        if (CHINESE_FOOD.contains(menu)) {
            return CHINESE.categoryName;
        }
        if (ASIAN_FOOD.contains(menu)) {
            return ASIAN.categoryName;
        }
        return WESTERN.categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
