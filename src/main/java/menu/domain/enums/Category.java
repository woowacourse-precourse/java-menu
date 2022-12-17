package menu.domain.enums;

import menu.domain.Food;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableList;

public enum Category {

    JAPANESE(1,
            "일식",
            List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    ),
    KOREAN(2,
            "한식",
            List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    ),
    CHINESE(3,
            "중식"
            , List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    ),
    ASIAN(4,
            "아시안",
            List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    ),
    WESTERN(5,
            "양식",
            List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    ),
    ;

    private final int number;
    private final List<Food> foods;
    private final String categoryName;

    Category(int number, String categoryName, List<String> foods) {
        this.number = number;
        this.categoryName = categoryName;
        this.foods = foods.stream()
                .map(it -> new Food(this, it))
                .collect(toUnmodifiableList());
    }

    public static Category mapByNumber(final int number) {
        return stream(values())
                .filter(it -> it.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("번호에 해당하는 카테고리가 없습니다."));
    }

    public static Category mapByName(final String name) {
        for (Category category : values()) {
            if (isContainFood(name, category)) {
                return category;
            }
        }
        throw new IllegalArgumentException("해당 음식을 포함한 카테고리가 존재하지 않습니다.");
    }

    private static boolean isContainFood(String name, Category category) {
        List<Food> foods = category.foods;
        for (Food food : foods) {
            if (food.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int number() {
        return number;
    }

    public List<String> foodNames() {
        return foods.stream()
                .map(Food::name)
                .collect(toUnmodifiableList());
    }

    public static Food mapFoodByName(String foodName) {
        for (Category category : values()) {
            Food food = findFood(foodName, category);
            if (food != null) {
                return food;
            }
        }
        throw new IllegalArgumentException("해당하는 음식이 존재하지 않습니다.");
    }

    private static Food findFood(String foodName, Category category) {
        return category.foods.stream()
                .filter(it -> it.name().equals(foodName))
                .findAny()
                .orElse(null);
    }

}
