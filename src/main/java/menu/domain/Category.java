package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Category {

    JAPANESE(1),
    KOREAN(2),
    CHINESE(3),
    ASIAN(4),
    WESTERN(5);

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

    Category(int number) {
        this.number = number;
    }

    public static List<String> findFoodBy(int RandomNumber) {
        return Arrays.stream(values())
                .filter(category -> category.number == RandomNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NUMBER))
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
}
