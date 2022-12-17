package menu.config;

import menu.domain.Category;
import menu.domain.Food;

import java.util.List;

import static menu.domain.Category.*;

public class InitData {
    public static List<Category> loadCategoryDummy() {
        return List.of(
                JAPANESE_FOOD_CATEGORY,
                KOREAN_FOOD_CATEGORY,
                CHINESE_FOOD_CATEGORY,
                ASIAN_FOOD_CATEGORY,
                WESTERN_FOOD_CATEGORY
        );
    }
    public static List<Food> loadFoodDummy() {
        return List.of(
                new Food(JAPANESE_FOOD_CATEGORY, "규동"),
                new Food(JAPANESE_FOOD_CATEGORY, "우동"),
                new Food(JAPANESE_FOOD_CATEGORY, "미소시루"),
                new Food(JAPANESE_FOOD_CATEGORY, "스시"),
                new Food(JAPANESE_FOOD_CATEGORY, "가츠동"),
                new Food(JAPANESE_FOOD_CATEGORY, "오니기리"),
                new Food(JAPANESE_FOOD_CATEGORY, "하이라이스"),
                new Food(JAPANESE_FOOD_CATEGORY, "라멘"),
                new Food(JAPANESE_FOOD_CATEGORY, "오코노미야끼"),

                new Food(KOREAN_FOOD_CATEGORY, "김밥"),
                new Food(KOREAN_FOOD_CATEGORY, "김치찌개"),
                new Food(KOREAN_FOOD_CATEGORY, "쌈밥"),
                new Food(KOREAN_FOOD_CATEGORY, "된장찌개"),
                new Food(KOREAN_FOOD_CATEGORY, "비빔밥"),
                new Food(KOREAN_FOOD_CATEGORY, "칼국수"),
                new Food(KOREAN_FOOD_CATEGORY, "불고기"),
                new Food(KOREAN_FOOD_CATEGORY, "떡볶이"),
                new Food(KOREAN_FOOD_CATEGORY, "제육볶음"),

                new Food(CHINESE_FOOD_CATEGORY, "깐풍기"),
                new Food(CHINESE_FOOD_CATEGORY, "볶음면"),
                new Food(CHINESE_FOOD_CATEGORY, "동파육"),
                new Food(CHINESE_FOOD_CATEGORY, "짜장면"),
                new Food(CHINESE_FOOD_CATEGORY, "짬뽕"),
                new Food(CHINESE_FOOD_CATEGORY, "마파두부"),
                new Food(CHINESE_FOOD_CATEGORY, "탕수육"),
                new Food(CHINESE_FOOD_CATEGORY, "토마토"),
                new Food(CHINESE_FOOD_CATEGORY, "달걀볶음"),
                new Food(CHINESE_FOOD_CATEGORY, "고추잡채"),

                new Food(ASIAN_FOOD_CATEGORY, "팟타이"),
                new Food(ASIAN_FOOD_CATEGORY, "카오 팟"),
                new Food(ASIAN_FOOD_CATEGORY, "나시고렝"),
                new Food(ASIAN_FOOD_CATEGORY, "파인애플 볶음밥"),
                new Food(ASIAN_FOOD_CATEGORY, "쌀국수"),
                new Food(ASIAN_FOOD_CATEGORY, "똠얌꿍"),
                new Food(ASIAN_FOOD_CATEGORY, "반미"),
                new Food(ASIAN_FOOD_CATEGORY, "월남쌈"),
                new Food(ASIAN_FOOD_CATEGORY, "분짜"),

                new Food(WESTERN_FOOD_CATEGORY, "라자냐"),
                new Food(WESTERN_FOOD_CATEGORY, "그라탱"),
                new Food(WESTERN_FOOD_CATEGORY, "뇨끼"),
                new Food(WESTERN_FOOD_CATEGORY, "끼슈"),
                new Food(WESTERN_FOOD_CATEGORY, "프렌치 토스트"),
                new Food(WESTERN_FOOD_CATEGORY, "바게트"),
                new Food(WESTERN_FOOD_CATEGORY, "스파게티"),
                new Food(WESTERN_FOOD_CATEGORY, "피자"),
                new Food(WESTERN_FOOD_CATEGORY, "파니니")
        );
    }
}
