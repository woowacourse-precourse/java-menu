package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.type.CategoryType;

public class CategoryMap {
    private final Map<CategoryType, List<String>> foodCategoryMap;

    public CategoryMap(Map<CategoryType, List<String>> foodCategoryMap) {
        this.foodCategoryMap = initializeCategoryMap();
    }

    public Map<CategoryType, List<String>> initializeCategoryMap() {
        Map<CategoryType, List<String>> initFoodCategory = new HashMap<>();
        initFoodCategory.put(CategoryType.JAPAN, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        initFoodCategory.put(CategoryType.KOREA, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        initFoodCategory.put(CategoryType.CHINA, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        initFoodCategory.put(CategoryType.ASIAN, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        initFoodCategory.put(CategoryType.WESTERN, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
        return initFoodCategory;
    }

    public Map<CategoryType, List<String>> getFoodCategoryMap(){
        return this.foodCategoryMap;
    }

    public List<String> getFoodList(CategoryType categoryType){
        return this.foodCategoryMap.get(categoryType);
    }

}
