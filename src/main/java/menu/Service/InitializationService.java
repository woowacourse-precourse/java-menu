package menu.Service;

import menu.domain.Category;
import menu.domain.CategoryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InitializationService {
    private static final String[] categoryNames = new String[]{"일식", "한식", "중식", "아시안", "양식"};
    private static final String[] japanFoodNames = new String[]{"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"};
    private static final String[] koreanFoodNames = new String[]{"김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"};
    private static final String[] chineseFoodNames = new String[]{"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"};
    private static final String[] asianFoodNames = new String[]{"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"};
    private static final String[] westernFoodNames = new String[]{"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"};

    private static final String JAPAN_FOOD = "일식";
    private static final String KOREAN_FOOD = "한식";
    private static final String CHINESE_FOOD = "중식";
    private static final String ASIAN_FOOD = "아시안";
    private static final String WESTERN_FOOD = "양식";

    public void initializeCategory() {
        initializeJapanCategory();
        initializeKoreanCategory();
        initializeChineseCategory();
        initializeAsianCategory();
        initializeWesternCategory();
    }

    public void initializeJapanCategory() {
        List<String> japanFoods = Arrays.stream(japanFoodNames)
                .collect(Collectors.toList());

        Category category = new Category(JAPAN_FOOD, japanFoods);
        CategoryRepository.addCategory(category);
    }

    public void initializeKoreanCategory() {
        List<String> koreanFoods = Arrays.stream(koreanFoodNames)
                .collect(Collectors.toList());

        Category category = new Category(KOREAN_FOOD, koreanFoods);
        CategoryRepository.addCategory(category);
    }

    public void initializeChineseCategory() {
        List<String> chineseFoods = Arrays.stream(chineseFoodNames)
                .collect(Collectors.toList());

        Category category = new Category(CHINESE_FOOD, chineseFoods);
        CategoryRepository.addCategory(category);
    }

    public void initializeAsianCategory() {
        List<String> asianFoods = Arrays.stream(asianFoodNames)
                .collect(Collectors.toList());

        Category category = new Category(ASIAN_FOOD, asianFoods);
        CategoryRepository.addCategory(category);
    }

    public void initializeWesternCategory() {
        List<String> westernFoods = Arrays.stream(westernFoodNames)
                .collect(Collectors.toList());

        Category category = new Category(WESTERN_FOOD, westernFoods);
        CategoryRepository.addCategory(category);
    }
}
