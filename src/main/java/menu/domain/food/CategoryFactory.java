package menu.domain.food;

import menu.domain.FoodRepository;

import java.util.List;

public class CategoryFactory {
    private static final List<String> JAPANESE_FOODS = List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
    private static final List<String> KOREAN_FOODS = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    private static final List<String> CHINESE_FOODS = List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
    private static final List<String> ASIAN_FOODS = List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    private static final List<String> WESTERN_FOODS = List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");

    public static void makeFood() {
        FoodRepository.addMenu(Category.JAPANESE, JAPANESE_FOODS);
        FoodRepository.addMenu(Category.KOREAN, KOREAN_FOODS);
        FoodRepository.addMenu(Category.CHINESE, CHINESE_FOODS);
        FoodRepository.addMenu(Category.ASIAN, ASIAN_FOODS);
        FoodRepository.addMenu(Category.WESTERN, WESTERN_FOODS);
    }
}
